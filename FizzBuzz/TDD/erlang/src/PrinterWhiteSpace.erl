-module('PrinterWhiteSpace').

-export([print/0]).

print() ->
    fun(Input) ->
	    string:join(Input, " ")
    end.
