-module('FizzBuzz_tests').

-include_lib("eunit/include/eunit.hrl").

stringFor_whenInputIsProvided_thenReturnInputAsString_test() ->
    Input = 1,
    Expected = "1",

    Actual = 'FizzBuzz':stringFor(Input),

    ?assertEqual(Expected, Actual).

stringFor_whenInputIsLessThanOne_thenThrowException_test() ->
    Input = 0,

    ?assertException(error, function_clause, 'FizzBuzz':stringFor(Input)).

stringFor_whenInputIsDivisibleBy3_thenReturnFizz_test() ->
    Input = 3,
    Expected = "Fizz",

    Actual = 'FizzBuzz':stringFor(Input),

    ?assertEqual(Expected, Actual).
