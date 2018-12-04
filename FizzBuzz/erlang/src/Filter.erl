-module('Filter').

-export([make/2]).

make(Divisor, Output) ->
    fun(Input) when Input rem Divisor == 0 -> Output;
       (_) -> ""
    end.
