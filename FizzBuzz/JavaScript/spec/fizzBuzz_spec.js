describe('stringFor', function() {
    it ('`stringFor` when input is processed, then return input as String', function() {
	const input = 1;
	const expected = '1';

	const actual = fizzBuzz.stringFor(input);

	expect(actual).toEqual(expected);
    });

    it('´stringFor´ when input is less than one, then throw IntegerLessThanOneException', function() {
	const input = 0;

	const actualFun = function(){ fizzBuzz.stringFor(input)};

	expect(actualFun).toThrow();
    });

    it('´stringFor´ when input is divisible by 3, then return ´Fizz´', function(){
	const input = 3;
	const expected = 'Fizz';

	const actual = fizzBuzz.stringFor(input);

	expect(actual).toEqual(expected);
    });
});

const FizzBuzz = require('../index.js').fizzbuzz;
const fizzBuzz = new FizzBuzz();
