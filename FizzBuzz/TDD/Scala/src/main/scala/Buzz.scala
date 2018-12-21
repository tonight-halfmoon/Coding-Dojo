object Buzz {
  val buzz = (integer: Int) => Divisible.isMultipleOf(integer, 5) match {
    case true => "Buzz"
    case _ => ""
  }
}
