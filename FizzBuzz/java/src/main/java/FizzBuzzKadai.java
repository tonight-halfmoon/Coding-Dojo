import java.util.List;

final class FizzBuzz {

  String stringFor(final int integer) throws Exception {
    return process(integer);
  }

  List<String> stringFor(final int [] input) throws Exception {
      return ProcessListJob.process(input);
  }

  private String process(final int integer) throws Exception {
    return ProcessJob.process(integer);
  }

  private static FizzBuzz fizzBuzz = new FizzBuzz();

  private FizzBuzz() {}

  static FizzBuzz getInstance() { return fizzBuzz; }
}
