const filtersProvider = require('./FiltersProvider').filtersProvider

filterFun = (input) => {
    throwIntegerLessThanOneException(input)
    return tt(input)
}

tt = (input) => {
    const result = applyFilters(input, filtersProvider.all(), '')
    if ('' === result.trim()) {
	return input.toString()
    }
    return result
}

applyFilters = (input, filters, result) => {
    if(0 === filters.size)
    {
	return result
    }
    const nextFilter = filters[Symbol.iterator]().next().value
    const partAnswer = nextFilter(input)
    filters.delete(nextFilter)
    return applyFilters(input, filters, result.concat(partAnswer))
}

throwIntegerLessThanOneException = (input) => {
    if (1 > input) {
	throw new IntegerLessThanOneException(input)
    }
}

module.exports = { filterJob: {  process: filterFun } }
