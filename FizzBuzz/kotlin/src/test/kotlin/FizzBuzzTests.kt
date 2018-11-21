import org.junit.Test
import org.junit.Before
import org.junit.After
import kotlin.test.assertEquals

class FizzBuzzTest {

	private val Fizz: (Int) -> String = { number -> when(0 == number % 3) { true -> "Fizz" else -> ""}}
	private val Buzz: (Int) -> String = { number -> when(0 == number % 5) { true -> "Buzz" else -> ""}}

	@Before
	fun setup()
	{
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
}
