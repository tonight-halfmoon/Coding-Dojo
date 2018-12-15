import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

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
  public void stringFor_whenInputNotDivisibleBy3_or5_thenReturnInputAsString()
      throws Exception {
    final int input = 1;
    final String expected = "1";

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }

  @Test
  public void stringFor_whenInputDivisibleBy3_thenReturnFizz()
      throws Exception {
    final int input = 3;
    final String expected = "Fizz";

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }

  @Test
  public void stringFor_whenInputDivisibleBy5_thenReturnBuzz()
      throws Exception {
    final int input = 5;
    final String expected = "Buzz";

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }

  @Test
  public void stringFor_whenInputDivisibleBy3_and5_thenReturnFizzBuzz()
      throws Exception {
    final int input = 15;
    final String expected = "FizzBuzz";

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }

  @Test(expected = Exception.class)
  public void stringFor_whenInputLessThan1_thenThrowException()
      throws Exception {
    final int input = 0;

    fizzBuzz.stringFor(input);
  }

    /*@Test
  public void stringFor_givenListOfInteger_thenReturnResultAsWhiteSpaceSeparatedString()
      throws Exception {
    final int [] input = new int [] {1,3,5,7,15};
    final String expected = "1 Fizz Buzz 7 FizzBuzz";

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
    }*/

  @Test
  public void stringFor_givenListOfInteger_thenReturnResultAsListOfString()
      throws Exception {
    final int [] input = new int [] {1,3,5,7,15};
    final List<String> expected = Arrays.asList(new String [] {"1", "Fizz", "Buzz", "7", "FizzBuzz"});

    final List<String> actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }
}
