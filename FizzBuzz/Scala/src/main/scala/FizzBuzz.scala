object FizzBuzz {

  private var printers : List[(Any) => Any] = Nil

  def stringFor(input: Any): Any =
  {
    val result = process(input)
    print(result)
  }

  def removeAllPrinters()
  {
    printers = Nil
  }

  def addPrinter(printer: (Any) => Any)
  {
    printers = printer::printers
  }

  private def process(input: Any) : Any =
  {
    FilterJob.filter(input)
  }

  private def print(result: Any): Any =
  {
    printers match{
      case Nil =>
        result
      case _ =>
        printWith(result, printers)
    }
  }

  private def printWith(value: Any, printers: List[(Any) => Any]): Any =
  {
    printers.head(value)
  }
}
