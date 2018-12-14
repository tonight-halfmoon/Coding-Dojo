import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTests {

  private final FizzBuzz fizzBuzz = FizzBuzz.getInstance();

  @Before
  public void initialize() {
    FiltersProvider.add(new Fizz());
    FiltersProvider.add(new Buzz());
  }

  @After
  public void cleanUp() {
      FiltersProvider.removeAll();
  }

  @Test
  public void
  stringFor_whenIntegerIsNotDivisibleBy3_or5_thenReturnInputAsString()
      throws Exception {
    final int input = 1;
    final String expected = "1";

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }

  @Test
  public void stringFor_whenInputIsDivisibleBy3_thenReturnFizz()
      throws Exception {
    final int input = 3;
    final String expected = "Fizz";

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }

  @Test
  public void stringFor_whenInputIsDivisibleBy5_thenReturnBuzz()
      throws Exception {
    final int input = 5;
    final String expected = "Buzz";

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }

  @Test
  public void stringFor_whenInputIsDivisibleBy3_and5_thenReturnFizzBuzz()
      throws Exception {
    final int input = 15;
    final String expected = "FizzBuzz";

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }

  @Test(expected = Exception.class)
  public void fb_when_number_less_than_1_then_throw_exception()
      throws Exception {
    final int input = 0;

    fizzBuzz.stringFor(input);
  }
}
