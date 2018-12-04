-module('FizzBuzz').

-export([stringFor/1]).

-export([addFilter/1, removeAllFilters/0]).

stringFor(Input) ->
    process(Input).

addFilter(Filter) ->
    'FiltersProvider':addFilter(Filter).

removeAllFilters() ->
    'FiltersProvider':removeFilters().

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
	applyFilters(Input, 'FiltersProvider':filters(), "").

applyFilters(_Input, [], StringForInput) ->
	StringForInput;
applyFilters(Input, [Filter|Filters], StringForInput) ->
	applyFilters(Input, Filters, lists:concat([Filter(Input), StringForInput])).

