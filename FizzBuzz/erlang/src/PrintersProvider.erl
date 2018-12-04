-module('PrintersProvider').

-export([addPrinter/1]).

-export([init/0]).

-define(req_add_printer, add_printer).

addPrinter(Printer) ->
    case isRunning() of
	true ->
	    request({?req_add_printer, Printer});
	false ->
	    start(),
	    request({?req_add_printer, Printer})
    end.

request({add_printer, Printer}) ->
    ?MODULE ! {add_printer, self(), Printer},
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

loop(Printers) ->
    receive
	{add_printer, From, Printer} ->
	    NewPrinters = [Printer|Printers],    
	    From ! length(NewPrinters),
	    loop(NewPrinters);
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
