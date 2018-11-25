-module('FiltersProvider').

-export([addFilter/1]).

-export([init/0]).
-define(req_add_filter, add_filter).

addFilter(Filter) ->
    case isRunning() of
	true ->
	    request(?req_add_filter, Filter);
	false ->
	    start(),
	    request(?req_add_filter, Filter)
    end.

request(add_filter, Filter) ->
    ?MODULE ! {add_filter, self(), Filter},
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
	    exit(normal)
	end.

isRunning() ->
    case whereis(?MODULE) of
	undefined ->
	    false;
	_Pid ->
	    true
    end.
