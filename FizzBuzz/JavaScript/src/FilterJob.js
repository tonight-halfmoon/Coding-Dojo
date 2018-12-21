const filtersProvider = require('./FiltersProvider').filtersProvider

filterFun = (input) => {
    throwIntegerLessThanOneException(input)
    const filters = filtersProvider.all()
    return applyFilters(input, filters, new Set())
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

throwIntegerLessThanOneException = (input) => {
    if (1 > input) {
	throw new IntegerLessThanOneException(input)
    }
}

module.exports = { filterJob: {  process: filterFun } }
