object PrinterJob {

  def print(result: Any): Any ={
    val printers = PrintersProvider.all()
    printers match {
      case Nil =>
        result
      case _ =>
        printWith(result, printers)
    }
  }

  private def printWith(value: Any, printers: List[(Any) => Any]): Any = {
    printers.head(value)
  }
}
