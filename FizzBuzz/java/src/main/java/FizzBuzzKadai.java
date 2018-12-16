import java.util.List;

final class FizzBuzz {

  String stringFor(final int integer) throws Exception {
    final String result = process(integer);
    return print(result);
  }

  String stringFor(final int [] input) throws Exception {
     final List<String> result = ProcessListJob.process(input);
     return print(result);
  }

  private String process(final int integer) throws Exception {
    return ProcessJob.process(integer);
  }

  private String print(final Object value) {
      return PrinterJob.print(value);
  }

  private static FizzBuzz fizzBuzz = new FizzBuzz();

  private FizzBuzz() {}

  static FizzBuzz getInstance() { return fizzBuzz; }
}
