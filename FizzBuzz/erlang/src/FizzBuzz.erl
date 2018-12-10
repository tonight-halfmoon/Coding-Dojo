-module('FizzBuzz').

-export([stringFor/1]).

-export([addFilter/1, removeAllFilters/0]).

-export([addPrinter/1, removeAllPrinters/0]).

stringFor(Input) ->
    Result = process(Input),
    print(Result).

addFilter(Filter) ->
    'FiltersProvider':add(Filter).

removeAllFilters() ->
    'FiltersProvider':removeAll().

addPrinter(Printer) ->
    'PrintersProvider':add(Printer).

removeAllPrinters() ->
    'PrintersProvider':removeAll().

process(Input) when is_list(Input) ->
    lists:map(fun filter/1, Input);
process(Input) when is_integer(Input) andalso Input > 0 ->
    filter(Input).

filter(Input) ->
    'FilterJob':filter(Input).

print(Value) ->
    Printers = 'PrintersProvider':printers(),
    'PrinterJob':print(Value, Printers).
