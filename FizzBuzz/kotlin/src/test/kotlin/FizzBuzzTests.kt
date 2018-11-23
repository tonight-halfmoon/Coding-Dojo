import org.junit.Test
import org.junit.Before
import org.junit.After
import kotlin.test.assertEquals

class FizzBuzzTest {

	@Before
	fun setup()
	{
		val isMultipleOf = fun(number: Int, divisor: Int): Boolean {return when (number % divisor) {0 -> true else -> false}}
		val Fizz: (Int) -> String = { number -> when(isMultipleOf(number, 3)) { true -> "Fizz" else -> ""}}
		val Buzz: (Int) -> String = { number -> when(isMultipleOf(number, 5)) { true -> "Buzz" else -> ""}}
		FizzBuzz.addFilter(Fizz)
		FizzBuzz.addFilter(Buzz)
	}

	@After
	fun cleanUp()
	{
		FizzBuzz.removeAllFilters()
	}

	@Test(expected = Exception::class)
	fun `'stringFor' when number is less than 1, then throw exception`()
	{
		FizzBuzz.stringFor(0)
	}

	@Test
	fun `'stringFor' when number is multiple of 3, then return 'Fizz'`()
	{
		val input = 3
		val expected = "Fizz"

		val actual = FizzBuzz.stringFor(3)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' when number is multiple of 5, then return 'Buzz'`()
	{
		val input = 5
		val expected = "Buzz"

		val actual = FizzBuzz.stringFor(5)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' when number is multiple of 3 and 5, then return 'FizzBuzz'`()
	{
		val input = 15
		val expected = "FizzBuzz"

		val actual =  FizzBuzz.stringFor(15)

		assertEquals(expected, actual)
	}
}