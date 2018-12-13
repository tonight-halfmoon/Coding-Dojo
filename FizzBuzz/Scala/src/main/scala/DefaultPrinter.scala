object DefaultPrinter extends AbstractPrinter {
  def printPart(value: Any): String = {
    value + " "
  }
}
