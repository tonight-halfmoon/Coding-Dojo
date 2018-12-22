Feature: Fizz or Buzz ?
	Everybody wants to quickly say Fizz or Buzz for input integer

	Scenario Outline: Return Fizz or Buzz
		Given Input is <input>
		When I ask what's that
		Then I should be told "<answer>"

	Examples:
		| input	| answer|
		| 3	| Fizz |
		| 5	| Buzz |
