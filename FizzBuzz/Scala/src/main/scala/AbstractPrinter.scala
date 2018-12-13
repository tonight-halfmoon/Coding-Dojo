abstract class AbstractPrinter extends PartialPrinter {
   def print(result: Any): Any = {
    result match {
      case string: String =>
        string
      case Nil =>
        ""
      case x::Nil =>
        x
      case x::xs =>
        printPart(x) + print(xs)
      case _ =>
        result
    }
  }
}
