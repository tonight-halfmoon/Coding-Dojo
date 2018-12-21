object PrintersProvider {
  private var printers : List[(Any) => Any] = Nil

  def all(): List[(Any) => Any] =
  {
    printers
  }

  def removeAll()
  {
    printers = Nil
  }

  def add(printer: (Any) => Any)
  {
    printers = printer::printers
  }
}
