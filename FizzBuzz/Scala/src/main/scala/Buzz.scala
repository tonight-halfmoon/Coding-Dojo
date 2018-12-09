object Buzz {
  val buzz = (number: Int) => (0 == number % 5) match {case true => "Buzz" case _ => ""}
}
