const fizzBuzz = require('../src/index').fizzbuzz
const filtersProvider = require('../src/index').filtersProvider
const fizz = require('../src/index').fizzFilter

describe('stringFor', function() {

    beforeEach(function() {
	filtersProvider.add(fizz)
    })

    afterEach(function() {
	filtersProvider.removeAll()
    })

    it ('`stringFor` when input is processed, then return input as String', function() {
	const input = 1
	const expected = '1'

	const actual = fizzBuzz.stringFor(input)

	expect(actual).toEqual(expected)
    })

    it('´stringFor´ when input is less than one, then throw IntegerLessThanOneException', function() {
	const input = 0

	const actualFun = function(){ fizzBuzz.stringFor(input)}

	expect(actualFun).toThrow()
    })

    it('´stringFor´ when input is divisible by 3, then return ´Fizz´', function(){
	const input = 3
	const expected = 'Fizz'

	const actual = fizzBuzz.stringFor(input)

	expect(actual).toEqual(expected)
    })

    it('´stringFor´ when input is divisible by 5, then return ´Buzz´', function(){
	const input = 5
	const expected = 'Buzz'
	const buzzFilter = (input) => {return 0 === input % 5 ? 'Buzz': ''}
	filtersProvider.add(buzzFilter)

	const actual = fizzBuzz.stringFor(input)

	expect(actual).toEqual(expected)
    })

    it('´stringFor´ given list of integer, then return result as white-space-separated string', function() {
	const input = [1,3,5,7,15]
	const expected = '1 Fizz Buzz 7 FizzBuzz'
	const buzzFilter = (input) => {return 0 === input % 5 ? 'Buzz': ''}
	filtersProvider.add(buzzFilter)

	const actual = fizzBuzz.stringFor(input)

	expect(actual).toEqual(expected)
    })
})
