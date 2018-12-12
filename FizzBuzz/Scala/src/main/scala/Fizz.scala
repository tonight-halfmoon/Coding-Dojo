object Fizz {
  def fizz = (integer: Int) => Divisible.isMultipleOf(integer, 3) match {
    case true => "Fizz"
    case _ => ""
  }
}
