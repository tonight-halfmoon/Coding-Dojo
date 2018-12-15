import java.util.List;

final class DefaultPrinter implements Printer {

  @Override
  public String print(final List<String> list) {
      return String.join(" ", list);
  }

  private DefaultPrinter() {}

  private static DefaultPrinter instance = new DefaultPrinter();

  public static DefaultPrinter getInstance() { return instance; }
}
