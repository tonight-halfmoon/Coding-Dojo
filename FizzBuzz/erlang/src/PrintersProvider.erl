-module('PrintersProvider').

-export([addPrinter/1, printers/0, print/1, removeAll/0]).

addPrinter(Printer) ->
    'ServiceProvider':add(Printer, ?MODULE).

printers() ->
    'ServiceProvider':services(?MODULE).

print(Input) ->
    Input.

removeAll() ->
    'ServiceProvider':removeAll(?MODULE).
