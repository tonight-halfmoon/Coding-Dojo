-module('FilterJob').

-export([filter/1]).

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
