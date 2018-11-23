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
		assertEquals("Fizz", FizzBuzz.stringFor(3))
	}

	@Test
	fun `'stringFor' when number is multiple of 5, then return 'Buzz'`()
	{
		assertEquals("Buzz", FizzBuzz.stringFor(5))
	}

	@Test
	fun `'stringFor' when number is multiple of 3 and 5, then return 'FizzBuzz'`()
	{
		assertEquals("FizzBuzz", FizzBuzz.stringFor(15))
	}
}
