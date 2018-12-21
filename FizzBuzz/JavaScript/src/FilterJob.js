const filtersProvider = require('./FiltersProvider').filtersProvider

filterFun = (input) => {
    const filters = filtersProvider.all()
    const result = applyFilters(input, filters, new Set())
    return Array.from(result).join(' ')
}

applyFilters = (input, filters, result) => {
    if(0 === filters.size)
    {
	return result
    }
    const nextFilter = filters[Symbol.iterator]().next().value
    const partAnswer = nextFilter(input)
    result.add(partAnswer)
    filters.delete(nextFilter)
    return applyFilters(input, filters, result)
}

module.exports = { filterJob: {  process: filterFun } }
