-module('FizzBuzz').

-export([stringFor/1]).

-export([addFilter/1, removeAllFilters/0]).

stringFor(Input) when is_list(Input) ->
    process(Input, "");
stringFor(Input) when Input > 0 ->
    process(Input).

addFilter(Filter) ->
    'FiltersProvider':addFilter(Filter).

removeAllFilters() ->
    'FiltersProvider':removeFilters().

process([], StringFor) ->
    lists:reverse(StringFor);
process([H|T], StringFor) ->
    process(T, [process(H)|StringFor]).

process(Input) ->
    StringForInput = applyFilters(Input),
    case length(StringForInput) == 0 of
	true ->
	    integer_to_list(Input);
	false ->
	    StringForInput
    end.

applyFilters(Input) ->
	applyFilters(Input, 'FiltersProvider':filters(), "").

applyFilters(_Input, [], StringForInput) ->
	StringForInput;
applyFilters(Input, [Filter|Filters], StringForInput) ->
	applyFilters(Input, Filters, lists:concat([Filter(Input), StringForInput])).

