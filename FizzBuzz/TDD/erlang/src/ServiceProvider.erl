-module('ServiceProvider').

-export([add/2, removeAll/1, services/1]).

-export([init/0]).

start(Name) ->
    register(Name, spawn(?MODULE, init, [])).

add(Service, Name) ->
    case isRunning(Name) of
	false ->
	    start(Name),
	    add(Service, Name);
	true ->
	   request(add, Service, Name)
    end.

request(add, Service, Name) ->
    Name ! {add, Service, self()},
    receive
	Reply ->
	    Reply
    after 300 ->
	    exit(tieout)
    end.

removeAll(Name) ->
    case isRunning(Name) of
	false ->
	    ok;
	true ->
	    Name ! stop,
	    []
    end.

services(Name) ->
    case isRunning(Name) of
	false ->
	    [];
	true ->
	    Name ! {services, self()},
	    receive
		Reply ->
		    Reply
	    after 300 ->
		    []
	    end
    end.

isRunning(Name) ->
    case whereis(Name) of
	undefined ->
	    false;
	Pid when is_pid(Pid) ->
	    true
    end.

init() ->
    loop([]).

loop(Services) ->
    receive
	{number_of_services, From} ->
	    From ! length(Services),
	    loop(Services);
	{add, Service, From} ->
	    NewServices = [Service|Services],
	    From ! length(NewServices),
	    loop(NewServices);
	stop ->
	    exit(normal);
	{services, From } ->
	    From ! Services,
	    loop(Services)
    end.
