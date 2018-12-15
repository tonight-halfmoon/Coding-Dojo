import java.util.List;

final class FizzBuzz {

  String stringFor(final int integer) throws Exception {
    return process(integer);
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
