-module('PrintersProvider').

-export([add/1, printers/0, removeAll/0]).

add(Printer) ->
    'ServiceProvider':add(Printer, ?MODULE).

printers() ->
    'ServiceProvider':services(?MODULE).

removeAll() ->
    'ServiceProvider':removeAll(?MODULE).
