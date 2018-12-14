import java.util.List;
import java.util.ArrayList;

enum FiltersProvider {
    $;
    private static final List<Filter> filtererList = new ArrayList<Filter>();

    static void addFilter(final Filter filterer) { filtererList.add(filterer); }

    static void removeAllFilters() { filtererList.clear(); }

    static List<Filter> all() {
	return filtererList;
    }
}
