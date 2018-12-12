object DefaultPrinter {
  def print(result: Any): Any = {
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
}
