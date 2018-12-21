const filters = new Set();

class FiltersProvider {
    add(filter) {
	addFilter(filter);
	return filters.size;
    }

    removeAll() {
	 filters.clear();
	 return filters.size;
    }
}

const addFilter = (filter) => {
    filters.add(filter);
};

module.exports = FiltersProvider;
