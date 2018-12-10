-module('FizzBuzz').

-export([stringFor/1]).

stringFor(Input) ->
    Result = process(Input),
    print(Result).

process(Input) when is_list(Input) ->
    lists:map(fun filter/1, Input);
process(Input) when is_integer(Input) andalso Input > 0 ->
    filter(Input).

filter(Input) ->
    'FilterJob':filter(Input).

print(Value) ->
    Printers = 'PrintersProvider':printers(),
    'PrinterJob':print(Value, Printers).
