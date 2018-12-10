final case class IntegerLessThanOneException(number: Int) extends RuntimeException("Expceted integer to be greater than 0, but found ".concat(number.toString))
{
}
