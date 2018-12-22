Feature: Is it Fizz ?
	Everybody wants to quickly say Fizz for integer divisible by 3

	Scenario: Return Fizz
		Given Input is 3
		When I ask what's that
		Then I should be told "Fizz"

	Scenario: Return Buzz
		Given Input is 5
		When I ask what's that
		Then I should be told "Buzz"
