object CommaSeparatedPrinter extends AbstractPrinter {
  override def printPart(value: Any): String = {
    value + ", "
  }
}
