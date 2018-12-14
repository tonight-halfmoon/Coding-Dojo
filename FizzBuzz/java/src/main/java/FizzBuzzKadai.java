
final class FizzBuzz {

  private static FizzBuzz fizzBuzz = new FizzBuzz();

  private FizzBuzz() {}

  static FizzBuzz getInstance() { return fizzBuzz; }

  String stringFor(final int integer) throws Exception {
    return process(integer);
  }

  private String process(final int integer) throws Exception {
    return ProcessJob.process(integer);
  }
}
