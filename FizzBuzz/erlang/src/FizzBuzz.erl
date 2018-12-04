-module('FizzBuzz').

-export([stringFor/1]).

-export([addFilter/1, removeAllFilters/0]).

-export([addPrinter/1, removeAllPrinters/0]).

stringFor(Input) ->
    Result = process(Input),
    print(Result).

addFilter(Filter) ->
    'FiltersProvider':addFilter(Filter).

removeAllFilters() ->
    'FiltersProvider':removeAllFilters().

addPrinter(Printer) ->
    'PrintersProvider':addPrinter(Printer).

removeAllPrinters() ->
    'PrintersProvider':removeAll().

process(Input) when is_list(Input) ->
    lists:map(fun filter/1, Input);
process(Input) when is_integer(Input) andalso Input > 0 ->
    filter(Input).

filter(Input) ->
    StringForInput = applyFilters(Input),
    case length(StringForInput) of
	0 ->
	    integer_to_list(Input);
	_ ->
	    StringForInput
    end.

applyFilters(Input) ->
    Filters =  'FiltersProvider':filters(),
    applyFilters(Input, Filters, "").

applyFilters(_Input, [], StringForInput) ->
	StringForInput;
applyFilters(Input, [NextFilter|Filters], StringForInput) ->
	applyFilters(Input, Filters, lists:concat([NextFilter(Input), StringForInput])).

print(Result) ->
    Printers = 'PrintersProvider':printers(),
    'PrinterJob':print(Result, Printers).
