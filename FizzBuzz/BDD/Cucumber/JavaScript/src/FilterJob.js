const fizzFilter = require("./fizzFilter").fizzFilter
const buzzFilter = require("./buzzFilter").buzzFilter

class FilterJob {
  filter(input) {
    const filters = [fizzFilter, buzzFilter]
    return this.applyFilters(filters, input)
  }

  applyFilters(filters, input) {
    return filters.map(filter => filter(input)).join("")
  }
}

module.exports = { filterJob: new FilterJob() }
