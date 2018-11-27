-module('FizzBuzz_tests').

-include_lib("eunit/include/eunit.hrl").

before() ->
    Fizz = fun(Input) when Input rem 3 == 0 -> "Fizz"; (_) -> "" end,
    Buzz = fun(Input) when Input rem 5 == 0 -> "Buzz"; (_) -> "" end,
    'FizzBuzz':addFilter(Fizz),
    'FizzBuzz':addFilter(Buzz).

afterEach() ->
    'FizzBuzz':removeAllFilters().

stringFor_whenInputIsNotDivisibleBy3_or5_thenReturnInputAsString_test() ->
    Input = 1, 
    Expected = "1",
    before(),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

stringFor_whenInputIsLessThanOne_thenThrowException_test() ->
    Input = 0,

    ?assertException(error, function_clause, 'FizzBuzz':stringFor(Input)).

stringFor_whenInputIsDivisibleBy3_thenReturnFizz_test() ->
    Input = 3,
    Expected = "Fizz",
    before(),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

stringFor_whenInputIsDivisibleBy5_thenReturnBuzz_test() ->
    Input = 5,
    Expected = "Buzz",
    before(),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

stringFor_whenInputIsDivisibleBy3_and5_thenReturnFizzBuzz_test() ->
    Input = 15,
    Expected = "FizzBuzz",
    before(),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

addFilter_alwaysIncreaseNumberOfFiltersBy1_test() ->
    Filter= fun() -> ok end,
    Expected = 3,
    before(),

    Actual = 'FizzBuzz':addFilter(Filter),
    afterEach(),

    ?assertEqual(Expected, Actual).

removeAllFilters_alwaysClearFiltersProviderState_test() ->
    Filter = fun() -> ok end,
    Expected = stop,
    'FizzBuzz':addFilter(Filter),

    Actual = 'FizzBuzz':removeAllFilters(),
    afterEach(),

    ?assertEqual(Expected, Actual).
