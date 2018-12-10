-module('ProcessJob').

-export([process/1]).

process(Input) when is_list(Input) ->
    lists:map(fun filter/1, Input);
process(Input) when is_integer(Input) andalso Input > 0 ->
    filter(Input).

filter(Input) ->
    'FilterJob':filter(Input).

