import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTests {

    @Test
    public void fb_when_number_not_multiple_of_3_or_5_then_return_number()
    {
	assertEquals(String.valueOf(1), FizzBuzz.fb(1));
    }

    @Test
    public void fb_when_number_multiple_of_3_then_return_Fizz()
    {
	assertEquals("Fizz", FizzBuzz.fb(3));
    }
}
