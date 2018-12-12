object CommaSeparatedPrinter {
  def print(value: Any): Any = {
    value match {
      case string: String =>
        string
      case Nil =>
        ""
      case x::Nil =>
        x
      case x::xs =>
        x + ", " + print(xs)
      case _ =>
        value
    }
  }
}
