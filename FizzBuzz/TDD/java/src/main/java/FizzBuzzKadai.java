final class FizzBuzz {

  String stringFor(final Object input) throws Exception {
    final Object result = process(input);
    return print(result);
  }

  private Object process(final Object input) throws Exception {
    return ProcessObjectJob.process(input);
  }

  private String print(final Object value) {
      return PrinterJob.print(value);
  }

  private static FizzBuzz fizzBuzz = new FizzBuzz();

  private FizzBuzz() {}

  static FizzBuzz getInstance() { return fizzBuzz; }
}
