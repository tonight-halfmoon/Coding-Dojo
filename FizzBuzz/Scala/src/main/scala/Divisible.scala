object Divisible {
  def isMultipleOf = (number: Int, divisor: Int) => (number % divisor) match {case 0 => true case _ => false}
}
