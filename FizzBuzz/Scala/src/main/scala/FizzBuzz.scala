object FizzBuzz {

  private var filters : List[(Int) => String] = Nil
  private var printers : List[(List[String]) => String] = Nil

  def stringFor(input: Any) : Any =
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

  def addPrinter(printer: (List[String]) => String) =
  {
    printers = printer::printers
  }

  def removeAllPrinters() =
  {
    printers = Nil
  }

  private def process(input: Any) : String =
  {
    input match {
      case integer: Int =>
        process(integer)
      case x::xs =>
        process(x::xs)
      case _ =>
        None.toString
    }
  }

  private def process(input: List[Any]): String =
  {
    process(input, Nil)
  }

  private def process(input: List[Any], result: List[String]): String =
  {
    input match {
      case x::xs =>
        process(xs, result :+ process(x))
      case Nil =>
        print(result)
    }
  }

  private def process(input: Int) : String =
  {
    throwIntegerLessThanOneException(input)
    val result = applyFilters(input)
    result.isEmpty() match {
      case true =>
        input.toString
      case _ =>
        result
    }
  }

  private def applyFilters(input: Int): String =
  {
    return applyFilters(input, filters, "")
  }

  @scala.annotation.tailrec
  private def applyFilters(input: Int, filters: List[(Int) => String], result: String): String =
  {
    filters match {
      case Nil =>
        result
      case _ =>
        applyFilters(input, filters.tail, result.concat(filters.head(input)))
    }
  }

  private def throwIntegerLessThanOneException(input: Int) =
  {
    if (1 > input) {
      throw new IntegerLessThanOneException()
    }
  }

  private def print(result: List[String]): String =
  {
    printers match {
      case Nil =>
        DefaultPrinter.print(result)
      case _ =>
        printers.head(result)
    }
  }
}
