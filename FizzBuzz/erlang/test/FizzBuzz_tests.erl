-module('FizzBuzz_tests').

-include_lib("eunit/include/eunit.hrl").

stringFor_whenInputIsNotDivisibleBy3_or5_thenReturnInputAsString_test() ->
    Input = 1, 
    Expected = "1",
    beforeEach(),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

stringFor_whenInputIsLessThanOne_thenThrowException_test() ->
    Input = 0,
    ExpectedError = error,
    ExpectedReason = function_clause,

    ?assertException(ExpectedError, ExpectedReason, 'FizzBuzz':stringFor(Input)).

stringFor_whenInputIsDivisibleBy3_thenReturnFizz_test() ->
    Input = 3,
    Expected = "Fizz",
    beforeEach(),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

stringFor_whenInputIsDivisibleBy5_thenReturnBuzz_test() ->
    Input = 5,
    Expected = "Buzz",
    beforeEach(),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

stringFor_whenInputIsDivisibleBy3_and5_thenReturnFizzBuzz_test() ->
    Input = 15,
    Expected = "FizzBuzz",
    beforeEach(),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

beforeEach() ->
    Fizz = fun(Input) when Input rem 3 == 0 -> "Fizz"; (_) -> "" end,
    Buzz = fun(Input) when Input rem 5 == 0 -> "Buzz"; (_) -> "" end,
    'FizzBuzz':addFilter(Fizz),
    'FizzBuzz':addFilter(Buzz).

afterEach() ->
    'FizzBuzz':removeAllFilters().

stringFor_whenListOfIntergerProvided_thenReturnAStringOfAllStringFor_test() ->
    beforeEach(),
    Input = [1,2,3,5,7,15],
    Expected = ["1", "2", "Fizz", "Buzz" ,"7", "FizzBuzz"],

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).
