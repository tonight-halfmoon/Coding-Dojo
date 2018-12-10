object Buzz {
  def buzz = (number: Int) => Divisible.isMultipleOf(number, 5) match {case true => "Buzz" case false => ""}
}
