object FilterJob {

  def filter(input: Any): Any =
  {
    input match {
      case integer: Int =>
        filter(integer)
      case x::xs =>
        filter(x::xs, Nil)
      case _ =>
        input
    }
  }

  private def filter(input: List[Any], result: List[Any]) : Any =
  {
    input match {
      case Nil =>
        result
      case x::xs =>
       filter(xs, result :+ filter(x))
    }
  }

  private def filter(input: Int): String =
  {
    throwIntegerLessThanOneException(input)
    val result = applyFilters(input)
    result.isEmpty() match
    {
      case true =>
        input.toString
      case _ =>
        result
    }
  }

  private def applyFilters(input: Int): String =
  {
    val filters = FiltersProvider.all()
    applyFilters(input, filters.reverse, "")
  }

  private def applyFilters(input: Int, filters: List[(Int) => String], result: String): String =
  {
    filters match
    {
      case Nil =>
        result
      case _ =>
        applyFilters(input, filters.tail, result.concat(filters.head(input)))
    }
  }

  private def throwIntegerLessThanOneException(input: Int) =
  {
    if (1 > input) {
      throw new IntegerLessThanOneException(input)
    }
  }
}
