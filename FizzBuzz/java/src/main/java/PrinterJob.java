import java.util.List;

enum PrinterJob {
  $;

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
