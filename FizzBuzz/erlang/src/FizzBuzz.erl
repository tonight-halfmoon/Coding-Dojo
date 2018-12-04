-module('FizzBuzz').

-export([stringFor/1]).

-export([addFilter/1, removeAllFilters/0]).

-export([addPrinter/1]).

stringFor(Input) ->
    Result = process(Input),
    print(Result).

addFilter(Filter) ->
    'FiltersProvider':addFilter(Filter).

removeAllFilters() ->
    'FiltersProvider':removeAllFilters().

addPrinter(Printer) ->
    'PrintersProvider':addPrinter(Printer).

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
    print(Result, Printers).

print(Value, []) ->
    Value;
print(Value, [NextPrinter|Printers]) ->
    Result = printWith(Value, NextPrinter),
    case length(Result) of
	0 ->
	    print(Value, Printers);
	_ ->
	    Result
    end.

printWith(Value, Printer) ->
    case isInteger(Value) of
	true ->
	    Value;
	false ->
	    try Printer(Value) of
		Result ->
		    Result
	    catch
		error:badarg ->
		    ""
	    end
    end.

isInteger(Value) when is_integer(Value) ->
    true;
isInteger(Input) ->
    try list_to_integer(Input) of
	_Integer ->
	    true
    catch
	error:badarg ->
	    false
    end.
