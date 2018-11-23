-module('FizzBuzz_tests').

-include_lib("eunit/include/eunit.hrl").

stringFor_ReturnEmptyString_test() ->
    Expected = "",
    
    Actual = 'FizzBuzz':stringFor(),
    
    ?assertEqual(Expected, Actual).
