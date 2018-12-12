object FiltersProvider {
  private var filters: List[(Int) => String] = Nil

  def all(): List[(Int) => String] = {
    return filters
  }

  def add(filter: (Int) => String) = {
    filters = filter::filters
  }

  def removeAll() {
    filters = Nil
  }
}
