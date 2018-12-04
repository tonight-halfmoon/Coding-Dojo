-module('Fizz').

-export([fizz/0]).

fizz() ->
    fun(Input) when Input rem 3 == 0 -> "Fizz";
       (_) -> ""
    end.
