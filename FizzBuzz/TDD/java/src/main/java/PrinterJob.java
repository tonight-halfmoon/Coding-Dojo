import java.util.List;
import java.util.Arrays;

enum PrinterJob {
  $;

  static String print(final Object value) {
      if (value instanceof List<?>) {
	  return print((List<String>) value);
      }
      if(value instanceof String) {
	  return (String) value;
      }
      throw new UnexpectedObjectTypeException(value);
  }

  static String print(final List<String> list) {
      final List<Printer> printers = PrintersProvider.all();
      if (!printers.isEmpty()) {
	  final Printer firstPrinter = printers.get(0);
	  if(firstPrinter != null)
	      {
		  return firstPrinter.print(list);
	      }
      }
      return DefaultPrinter.getInstance().print(list);
  }
}
