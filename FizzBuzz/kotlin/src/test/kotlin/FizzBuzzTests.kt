import org.junit.Test
import org.junit.Before
import org.junit.After
import kotlin.test.assertEquals

class FizzBuzzTest {

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

	@Test(expected = IntegerLessThanOneException::class)
	fun `'stringFor' when input is less than 1, then throw exception`()
	{
		val input = 0

		FizzBuzz.stringFor(input)
	}

	@Test
	fun `'stringFor' when input is multiple of 3, then return 'Fizz'`()
	{
		val input = 3
		val expected = "Fizz"

		val actual = FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' when input is multiple of 5, then return 'Buzz'`()
	{
		val input = 5
		val expected = "Buzz"

		val actual = FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' when input is multiple of 3 and 5, then return 'FizzBuzz'`()
	{
		val input = 15
		val expected = "FizzBuzz"

		val actual =  FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' when input is multiple of 2, then return 'Foo'`()
	{
		val input = 2
		val expected = "Foo"
		FizzBuzz.addFilter(Foo)

		val actual = FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' given list of integer, return result as whitespace-separated string`()
	{
		val input = listOf(1,3,5,7,15)
		val expected = "1 Fizz Buzz 7 FizzBuzz"

		val actual = FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}
}
