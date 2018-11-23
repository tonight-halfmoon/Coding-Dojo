import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTests {

    @Test
    public void stringFor_whenIntegerIsNotDivisibleBy3_or5_thenReturnIntegerAsString() throws Exception
    {
	final int input = 1;
	final String expected = "1";

	final String actual = FizzBuzz.stringFor(input);
	assertEquals(expected, actual);
    }

    @Test
    public void stringFor_whenIntegerIsDivisibleBy3_thenReturnFizz() throws Exception
    {
	final int input = 3;
	final String expected = "Fizz";

	final String actual = FizzBuzz.stringFor(input);

	assertEquals(expected, actual);
    }

    @Test
    public void stringFor_whenInputIsDivisibleBy5_thenReturnBuzz() throws Exception
    {
	final int input = 5;
	final String expected = "Buzz";

	final String actual = FizzBuzz.stringFor(input);

	assertEquals(expected, actual);
    }

    @Test
    public void stringFor_whenInputIsDivisibleBy3_and5_thenReturnFizzBuzz() throws Exception
    {
	final int input = 15;
	final String expected = "FizzBuzz";

	final String actual = FizzBuzz.stringFor(input);

	assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void fb_when_number_less_than_1_then_throw_exception() throws Exception
    {
	final int input = 0;

	FizzBuzz.stringFor(input);
    }
}
