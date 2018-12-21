const filters = new Set()

class FiltersProvider {
    add(filter) {
	filters.add(filter)
	return filters.size
    }

    removeAll() {
	 filters.clear()
	 return filters.size
    }
    
    all() {
	return new Set(Array.from(filters))
    }
}

module.exports = { filtersProvider: new FiltersProvider() }
