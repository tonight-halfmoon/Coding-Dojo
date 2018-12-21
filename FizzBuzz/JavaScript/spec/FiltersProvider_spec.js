describe("FiltersProvider", function() {
  it("´add´ always increase number of filters by one", function() {
    const input = () => "Filter";
    const expected = 1;

    const actual = filtersProvider.add(input);

    expect(actual).toEqual(expected);
  });

  it("´removeAll´ always remove all available filters", function() {
    filtersProvider.removeAll();
    const inputFilter1 = () => "filter1";
    const inputFilter2 = () => "filter2";
    filtersProvider.add(inputFilter1);
    const currentSize = filtersProvider.add(inputFilter2);
    expect(currentSize).toEqual(2);
    const expected = 0;

    const actual = filtersProvider.removeAll();

    expect(actual).toEqual(expected);
  });
});

const FiltersProvider = require("../index.js").filtersProvider;
const filtersProvider = new FiltersProvider();
