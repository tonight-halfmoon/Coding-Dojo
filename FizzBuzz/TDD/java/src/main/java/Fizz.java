final class Fizz implements Filter {
  @Override
  public String filter(final int integer) {
      return Divisible.isMultipleOf(integer, 3) ? "Fizz" : "";
  }
  private static final Fizz instance = new Fizz();
  private Fizz() {}
  public static Fizz getInstance(){ return instance; }
}
