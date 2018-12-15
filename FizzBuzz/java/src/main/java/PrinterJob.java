import java.util.List;

enum PrinterJob {
  $;

  static String print(final List<String> list) {
      return String.join(" ", list);
  }
}
