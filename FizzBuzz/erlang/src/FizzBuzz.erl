-module('FizzBuzz').

-export([stringFor/1]).

stringFor(Input) ->
    Result = process(Input),
    print(Result).

process(Input) ->
    'ProcessJob':process(Input).

print(Value) ->
    'PrinterJob':print(Value).
