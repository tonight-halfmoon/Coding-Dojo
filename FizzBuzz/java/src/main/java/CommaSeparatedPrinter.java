import java.util.List;

final class CommaSeparatedPrinter implements Printer {

  @Override
  public String print(final List<String> list) {
      return String.join(", ", list);
  }

  private CommaSeparatedPrinter() {}

  private static final CommaSeparatedPrinter instance = new CommaSeparatedPrinter();

  public static CommaSeparatedPrinter getInstance() { return instance; }
}
