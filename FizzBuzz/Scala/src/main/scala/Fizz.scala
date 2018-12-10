object Fizz {
  def fizz = (number: Int) => Divisible.isMultipleOf(number, 3) match {case true => "Fizz" case false => ""}
}
