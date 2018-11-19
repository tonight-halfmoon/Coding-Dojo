object FizzBuzz {

  private var filters : List[(Int) => String] = Nil

  def stringFor(number: Int): Any =
  {
    throwNumberLessThanOneException(number)
    return convert(number)
  }

  def addFilter(filter: (Int) => String) =
  {
    filters = filter::filters
  }

  private def throwNumberLessThanOneException(number: Int) =
    (1 > number) match {
      case true =>
        throw new NumberLessThanOneException(number)
      case _ =>
        ;
    }

  private def convert(number : Int): Any =
  {
    val stringForNumber = applyFilters(number)
    stringForNumber.isEmpty() match
    {
      case true =>
        return number
      case _ =>
        return stringForNumber
    }
  }

  private def applyFilters(number: Int): String =
  {
    return applyFilters(number, filters.reverse, "")
  }

  private def applyFilters(number: Int, filters: List[(Int) => String], stringForNumber: String): String =
  {
    filters match
    {
      case Nil =>
        return stringForNumber
      case _ =>
        applyFilters(number, filters.tail, stringForNumber.concat(filters.head(number)))
    }
  }
}
