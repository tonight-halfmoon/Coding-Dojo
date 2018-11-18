import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTests {

    @Test
    public void fb_when_number_not_multiple_of_3_or_5_then_return_number() throws Exception
    {
	assertEquals(String.valueOf(1), FizzBuzz.fb(1));
    }

    @Test
    public void fb_when_number_multiple_of_3_then_return_Fizz() throws Exception
    {
	assertEquals("Fizz", FizzBuzz.fb(3));
    }

    @Test
    public void fb_when_number_multiple_of_5_then_return_Buzz() throws Exception
    {
	assertEquals("Buzz", FizzBuzz.fb(5));
    }

    @Test
    public void fb_when_number_multiple_of_3_and_5_then_return_FizzBuzz() throws Exception
    {
	assertEquals("FizzBuzz", FizzBuzz.fb(15));
    }

    @Test(expected = Exception.class)
    public void fb_when_number_less_than_1_then_throw_exception() throws Exception
    {
	FizzBuzz.fb(0);
    }
}
