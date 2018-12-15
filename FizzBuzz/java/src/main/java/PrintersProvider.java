import java.util.List;
import java.util.ArrayList;

enum PrintersProvider {
    $;

    private static final List<Printer> printerList = new ArrayList<Printer>();

    static void add(final Printer printer) { printerList.add(printer); }

    static void removeAll() { printerList.clear(); }

    static List<Printer> all() {
	return new ArrayList(printerList);
    }
}
