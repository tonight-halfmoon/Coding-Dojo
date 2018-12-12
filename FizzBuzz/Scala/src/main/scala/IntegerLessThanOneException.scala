final case class IntegerLessThanOneException(integer: Int)
    extends RuntimeException("Expceted integer to be greater than 0, but found ".concat(integer.toString))
{
}
