object Divisible {
  def isMultipleOf = (integer: Int, divisor: Int) => (integer % divisor) match {
    case 0 => true
    case _ => false
  }
}
