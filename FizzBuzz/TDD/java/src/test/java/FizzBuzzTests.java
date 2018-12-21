import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTests {

  private final FizzBuzz fizzBuzz = FizzBuzz.getInstance();

  @Before
  public void initialize() {
      FiltersProvider.add(Fizz.getInstance());
      FiltersProvider.add(Buzz.getInstance());
  }

  @After
  public void cleanUp() {
      FiltersProvider.removeAll();
      PrintersProvider.removeAll();
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

  @Test
  public void stringFor_givenListOfInteger_andDefaultPrinter_thenReturnResultAsWhiteSpaceSeparatedString()
      throws Exception {
    final int [] input = new int [] {1,3,5,7,15};
    final String expected = "1 Fizz Buzz 7 FizzBuzz";
    PrintersProvider.add(DefaultPrinter.getInstance());

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }

  @Test
  public void stringFor_givenListOfInteger_andCommaSeparatedPrinter_thenReturnResultAsCommaSeparatedString()
      throws Exception {
    final int [] input = new int [] {1,3,5,7,15};
    final String expected = "1, Fizz, Buzz, 7, FizzBuzz";
    PrintersProvider.add(CommaSeparatedPrinter.getInstance());

    final String actual = fizzBuzz.stringFor(input);

    assertEquals(expected, actual);
  }

  @Test
  public void stringFor_whenInputIsDivisibleBy2_thenReturnFoo()
      throws Exception {
      final int input = 2;
      final String expected = "Foo";
      final Filter filter = Foo.getInstance();
      FiltersProvider.add(filter);

      final String actual = fizzBuzz.stringFor(input);

      assertEquals(expected, actual);
  }

  @Test
  public void newFilterFoo_ExcatlyOnlyOneInstanceInJVM_canBeInstantiated()
  {
      final Filter filterFoo1 = Foo.getInstance();
      final Filter filterFoo2 = Foo.getInstance();

      assertEquals(filterFoo1, filterFoo2);
  }

  @Test
  public void newFilterFizz_ExcatlyOnlyOneInstanceInJVM_canBeInstantiated()
  {
      final Filter filterFizz1 = Fizz.getInstance();
      final Filter filterFizz2 = Fizz.getInstance();

      assertEquals(filterFizz1, filterFizz2);
  }

  @Test
  public void newFilterBuzz_ExcatlyOnlyOneInstanceInJVM_canBeInstantiated()
  {
      final Filter filterBuzz1 = Buzz.getInstance();
      final Filter filterBuzz2 = Buzz.getInstance();

      assertEquals(filterBuzz1, filterBuzz2);
  }
}
