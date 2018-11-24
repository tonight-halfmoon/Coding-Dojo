-module('FizzBuzz_tests').

-include_lib("eunit/include/eunit.hrl").

stringFor_whenInputIsProvided_thenReturnInputAsString_test() ->
    Input = 1,
    Expected = "1",

    Actual = 'FizzBuzz':stringFor(Input),

    ?assertEqual(Expected, Actual).
