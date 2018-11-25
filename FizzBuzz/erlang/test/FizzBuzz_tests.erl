-module('FizzBuzz_tests').

-include_lib("eunit/include/eunit.hrl").

stringFor_whenInputIsNotDivisibleBy3_or5_thenReturnInputAsString_test() ->
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

stringFor_whenInputIsDivisibleBy5_thenReturnBuzz_test() ->
    Input = 5,
    Expected = "Buzz",

    Actual = 'FizzBuzz':stringFor(Input),

    ?assertEqual(Expected, Actual).

stringFor_whenInputIsDivisibleBy3_and5_thenReturnFizzBuzz_test() ->
    Input = 15,
    Expected = "FizzBuzz",

    Actual = 'FizzBuzz':stringFor(Input),

    ?assertEqual(Expected, Actual).

addFilter_alwaysIncreaseNumberOfFiltersBy1_test() ->
    Filter= fun() -> ok end,
    Expected = 1,

    Actual = 'FizzBuzz':addFilter(Filter),

    ?assertEqual(Expected, Actual).

