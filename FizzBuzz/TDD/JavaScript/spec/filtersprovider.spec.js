const filtersProvider = require('../src/index').filtersProvider
const { expect } = require('chai')

describe("FiltersProvider", function() {

  afterEach(function() {
    filtersProvider.removeAll()
  })
    
  it("´add´ always increase number of filters by one", function() {
    const input = () => "Filter"
    const expected = 1

    const actual = filtersProvider.add(input)

    expect(actual).to.eql(expected)
  })

  it("´removeAll´ always remove all available filters", function() {
    const inputFilter1 = () => "filter1"
    const inputFilter2 = () => "filter2"
    filtersProvider.add(inputFilter1)
    const currentSize = filtersProvider.add(inputFilter2)
    expect(currentSize).to.eql(2)
    const expected = 0

    const actual = filtersProvider.removeAll()

    expect(actual).to.eql(expected)
  })

  it('´all´ always return all available filters in same insert order', function() {
    const inputFilter1 = () => "filter1"
    const inputFilter2 = () => "filter2"
    const inputFilter3 = () => "filter3"
    filtersProvider.add(inputFilter1)
    filtersProvider.add(inputFilter2)
    filtersProvider.add(inputFilter3)
    const expected = [inputFilter1,
		      inputFilter2,
		      inputFilter3]

    const actual = Array.from(filtersProvider.all())
    expect(actual).to.have.ordered.members(expected)
  })
})
