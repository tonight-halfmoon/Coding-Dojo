class NumberLessThanOneException(number: Int) extends RuntimeException("Expceted number > 0, but found ".concat(number.toString()))
{
}
