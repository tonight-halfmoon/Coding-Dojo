import java.util.List;
import java.util.ArrayList;

enum FiltersProvider {
    $;
    private static final List<Filter> filtererList = new ArrayList<Filter>();

    static void add(final Filter filterer) { filtererList.add(filterer); }

    static void removeAll() { filtererList.clear(); }

    static List<Filter> all() {
	return new ArrayList(filtererList);
    }
}
