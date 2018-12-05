object FizzBuzz {

  private var filters : List[(Int) => String] = Nil

  def stringFor(input: Any): Any =
  {
    process(input)
  }

  def addFilter(filter: (Int) => String) =
  {
    filters = filter::filters
  }

  def removeAllFilters()
  {
    filters = Nil
  }

  private def throwNumberLessThanOneException(number: Int) =
    if (1 > number) {
      throw new NumberLessThanOneException(number)
    }

  private def process(input: Any) : Any =
  {
    input match {
      case integer: Int =>
        throwNumberLessThanOneException(integer)
        filter(integer)
      case x::xs =>
        filter(x::xs)
      case _ =>
        input
    }
  }

  private def filter(input: List[Any]) : Any =
  {
    input.mkString(" ")
  }

  private def filter(number : Int): String =
  {
    val stringForNumber = applyFilters(number)
    stringForNumber.isEmpty() match
    {
      case true =>
        return number.toString
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
