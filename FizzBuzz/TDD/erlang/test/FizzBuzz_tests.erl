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
    'ServiceConfigurator':addFilter('Fizz':fizz()),
    'ServiceConfigurator':addFilter('Buzz':buzz()).

afterEach() ->
    'ServiceConfigurator':removeAllFilters(),
    'ServiceConfigurator':removeAllPrinters().

stringFor_givenListOfIntergerAndPrinterCommaSeparated_thenReturnResultCommaSeparated_test() ->
    beforeEach(),
    Input = [1,2,3,5,7,15],
    'ServiceConfigurator':addPrinter('PrinterCommaSeparated':print()),
    Expected = "1, 2, Fizz, Buzz, 7, FizzBuzz",

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

stringFor_givenListOfIntegerAndPrinterWhiteSpace_thenReturnResultWhiteSpaceSeparated_test() ->
    beforeEach(),
    Input = [1,2,3,4,5,7,15],
    Expected = "1 2 Fizz 4 Buzz 7 FizzBuzz",
    'ServiceConfigurator':addPrinter('PrinterWhiteSpace':print()),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

stringFor_whenInputIsDivisibleBy2_thenReturnFoo_test() ->
    Input = 2,
    Expected = "Foo",
    'ServiceConfigurator':addFilter('Foo':foo()),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).

stringFor_givenListOfIntegersAndCommaSeparatedPrinterAndFiltersFizz_Buzz_and_Foo_thenReturnResultWithCommaSeparated_test() ->
    Input = [1,2,3,4,5,7,15],
    Expected = "1, Foo, Fizz, Foo, Buzz, 7, FizzBuzz",
    'ServiceConfigurator':addPrinter('PrinterCommaSeparated':print()),
    'ServiceConfigurator':addFilter('Fizz':fizz()),
    'ServiceConfigurator':addFilter('Buzz':buzz()),
    'ServiceConfigurator':addFilter('Foo':foo()),

    Actual = 'FizzBuzz':stringFor(Input),
    afterEach(),

    ?assertEqual(Expected, Actual).
