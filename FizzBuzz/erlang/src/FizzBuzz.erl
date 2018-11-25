-module('FizzBuzz').

-export([stringFor/1]).

stringFor(Input) when Input > 0 ->
    process(Input).

process(Input) ->
    StringForInput = applyFilters(Input),
    case length(StringForInput) == 0 of
	true ->
	    integer_to_list(Input);
	false ->
	    StringForInput
    end.

applyFilters(Input) ->
    fizzFilter(Input).

fizzFilter(Input) when Input rem 3 == 0 ->
    "Fizz";
fizzFilter(_Input) ->
    "".
