describe('stringFor', function() {
    it ('when input is processed then return input as String', function() {
	var input = 1;
	var expected = '1';

	var actual = fizzBuzz.stringFor(input);

	expect(actual).toEqual(expected);
    });
});

const FizzBuzz = require('../index.js').fizzbuzz;
const fizzBuzz = new FizzBuzz();
