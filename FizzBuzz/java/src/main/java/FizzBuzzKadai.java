import java.util.List;
import java.util.Arrays;

final class FizzBuzz {

  String stringFor(final int integer) throws Exception {
    final String result = process(integer);
    return print(Arrays.asList(new String [] {result}));
  }

  String stringFor(final int [] input) throws Exception {
     final List<String> result = ProcessListJob.process(input);
     return print(result);
  }

  private String process(final int integer) throws Exception {
    return ProcessJob.process(integer);
  }

  private String print(final List<String> list) {
      return PrinterJob.print(list);
  }

  private static FizzBuzz fizzBuzz = new FizzBuzz();

  private FizzBuzz() {}

  static FizzBuzz getInstance() { return fizzBuzz; }
}
