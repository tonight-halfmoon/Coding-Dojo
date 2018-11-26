-module('FiltersProvider').

-export([addFilter/1, filters/0, removeFilters/0]).

-export([init/0]).

-define(req_add_filter, add_filter).
-define(req_filters, filters).

addFilter(Filter) ->
    case isRunning() of
	true ->
	    request({?req_add_filter, Filter});
	false ->
	    start(),
	    request({?req_add_filter, Filter})
    end.

filters() ->
	case isRunning() of
		true ->
			request(?req_filters);
		false ->
			{error, service_not_running}
	end.

removeFilters() ->
	case isRunning() of
		true ->
			request(stop);
		false ->
			{error, service_not_running}
	end.

request({add_filter, Filter}) ->
    ?MODULE ! {add_filter, self(), Filter},
    receive
	Reply ->
	    Reply
    after 300 ->
	    exit(timeout)
    end;
request(stop) ->
	?MODULE ! stop;
request(Request) ->
	?MODULE ! {Request, self()},
	receive
	Reply ->
		Reply
	after 300 ->
		exit(timeout)
	end.

start() ->
    register(?MODULE, spawn(?MODULE, init, [])).

init() ->
    loop([]).

loop(Filters) ->
    receive
	{add_filter, From, Filter} ->
	NewFilters = [Filter|Filters],    
	From ! length(NewFilters),
	    loop(NewFilters);
	stop ->
	    exit(normal);
	{filters, From} ->
		From ! Filters,
		loop(Filters)
	end.

isRunning() ->
    case whereis(?MODULE) of
	undefined ->
	    false;
	_Pid ->
	    true
    end.
