-module('PrinterJob').

-export([print/2]).

print(Value, []) ->
    Value;
print(Value, [NextPrinter|Printers]) ->
    Result = printWith(Value, NextPrinter),
    case length(Result) of
	0 ->
	    print(Value, Printers);
	_ ->
	    Result
    end.

printWith(Value, Printer) ->
    case isInteger(Value) of
	true ->
	    Value;
	false ->
	    try Printer(Value) of
		Result ->
		    Result
	    catch
		error:badarg ->
		    ""
	    end
    end.

isInteger(Value) when is_integer(Value) ->
    true;
isInteger(Input) ->
    try list_to_integer(Input) of
	_Integer ->
	    true
    catch
	error:badarg ->
	    false
    end.
