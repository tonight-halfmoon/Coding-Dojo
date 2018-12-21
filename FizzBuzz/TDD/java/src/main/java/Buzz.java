final class Buzz implements Filter {
  @Override
  public String filter(final int integer) {
      return Divisible.isMultipleOf(integer, 5) ? "Buzz" : "";
  }
  private static final Buzz instance = new Buzz();
  private Buzz() {}
  public static Buzz getInstance() { return instance; }
}
