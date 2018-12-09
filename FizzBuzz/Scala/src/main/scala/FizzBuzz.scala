object FizzBuzz {

  private var filters : List[(Int) => String] = Nil
  private var printers : List[(Any) => Any] = Nil

  def stringFor(input: Any): Any =
  {
    val result = process(input)
    print(result)
  }

  def addFilter(filter: (Int) => String) =
  {
    filters = filter::filters
  }

  def removeAllFilters()
  {
    filters = Nil
  }

  def addPrinter(printer: (Any) => Any): Int =
  {
    printers = printer::printers
    printers.length
  }

  private def throwNumberLessThanOneException(number: Int) =
  {
    if (1 > number) {
      throw new NumberLessThanOneException(number)
    }
  }

  private def process(input: Any) : Any =
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
       filter(xs, result :+ process(x))
    }
  }

  private def filter(number: Int): String =
  {
    throwNumberLessThanOneException(number)
    val result = applyFilters(number)
    result.isEmpty() match
    {
      case true =>
        number.toString
      case _ =>
        result
    }
  }

  private def applyFilters(number: Int): String =
  {
    return applyFilters(number, filters.reverse, "")
  }

  private def applyFilters(number: Int, filters: List[(Int) => String], result: String): String =
  {
    filters match
    {
      case Nil =>
        result
      case _ =>
        applyFilters(number, filters.tail, result.concat(filters.head(number)))
    }
  }

  private def print(result: Any): Any =
  {
    printers match{
      case Nil =>
        printDefault(result)
      case _ =>
        printWith(result, printers)
    }
  }

  private def printDefault(result: Any): Any =
  {
    result match {
      case string: String =>
        string
      case Nil =>
        ""
      case x::Nil =>
        x
      case x::xs =>
        x + " " + print(xs)
      case _ =>
        result
    }
  }

  private def printWith(value: Any, printers: List[(Any) => Any]): Any =
  {
    printers.head(value)
  }
}
