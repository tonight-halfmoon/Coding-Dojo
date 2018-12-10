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
    Result = applyFilters(Input),
    case length(Result) of
	0 ->
	    integer_to_list(Input);
	_ ->
	    Result
    end.

applyFilters(Input) ->
    Filters =  'FiltersProvider':filters(),
    applyFilters(Input, Filters, "").

applyFilters(_Input, [], Result) ->
	Result;
applyFilters(Input, [NextFilter|Filters], Result) ->
	applyFilters(Input, Filters, lists:concat([NextFilter(Input), Result])).

print(Value) ->
    Printers = 'PrintersProvider':printers(),
    'PrinterJob':print(Value, Printers).
