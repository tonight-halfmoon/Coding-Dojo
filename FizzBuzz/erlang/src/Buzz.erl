-module('Buzz').

-export([buzz/0]).

buzz() ->
    fun(Input) when Input rem 5 == 0 -> "Buzz";
       (_) -> ""
    end.
