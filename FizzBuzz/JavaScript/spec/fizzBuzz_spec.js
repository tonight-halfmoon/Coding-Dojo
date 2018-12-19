describe('stringFor', function() {
    it ('`stringFor` when input is processed, then return input as String', function() {
	var input = 1;
	var expected = '1';

	var actual = fizzBuzz.stringFor(input);

	expect(actual).toEqual(expected);
    });

    it('´stringFor´ when input is less than one, then throw IntegerLessThanOneException', function() {
	var input = 0;

	var actualFun = function(){ fizzBuzz.stringFor(input)};

	expect(actualFun).toThrow();
    });
});

const FizzBuzz = require('../index.js').fizzbuzz;
const fizzBuzz = new FizzBuzz();
