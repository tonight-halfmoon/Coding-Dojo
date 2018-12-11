import org.junit.Test
import org.junit.Before
import org.junit.After
import kotlin.test.assertEquals

class FizzBuzzTest {

	@Before
	fun setup()
	{
		FiltersProvider.add(Fizz)
		FiltersProvider.add(Buzz)
		FizzBuzz.addPrinter(DefaultPrinter)
	}

	@After
	fun cleanUp()
	{
		FiltersProvider.removeAll()
		FizzBuzz.removeAllPrinters()
	}

	@Test(expected = IntegerLessThanOneException::class)
	fun `'stringFor' when input is less than 1, then throw exception`()
	{
		val input = 0

		FizzBuzz.stringFor(input)
	}

	@Test
	fun `'stringFor' when input is divisible by 3, then return 'Fizz'`()
	{
		val input = 3
		val expected = "Fizz"

		val actual = FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' when input is divisible by 5, then return 'Buzz'`()
	{
		val input = 5
		val expected = "Buzz"

		val actual = FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' when input is divisible by 3 and 5, then return 'FizzBuzz'`()
	{
		val input = 15
		val expected = "FizzBuzz"

		val actual =  FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' when input is divisible by 2, then return 'Foo'`()
	{
		val input = 2
		val expected = "Foo"
		FiltersProvider.add(Foo)

		val actual = FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' given list of integer and Default Printer, return result as whitespace-separated string`()
	{
		val input = listOf(1,3,5,7,15)
		val expected = "1 Fizz Buzz 7 FizzBuzz"

		val actual = FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' when input is not divisible by 3 or 5, then return input as String`()
	{
		val input = 1
		val expected = "1"

		val actual = FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

	@Test
	fun `'stringFor' given list of integer and comma separated printer, then return result as a comma-separated string for each integer's divisibility`() {
		val input = mutableListOf(1,3,5,7,15)
		val expected = "1, Fizz, Buzz, 7, FizzBuzz"
		FizzBuzz.addPrinter(CommaSeparatedPrinter)

		val actual = FizzBuzz.stringFor(input)

		assertEquals(expected, actual)
	}

}
