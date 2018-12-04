-module('Foo').

-export([foo/0]).

foo() ->
    fun(Input) when Input rem 2 == 0 -> "Foo";
       (_) -> ""
    end.
