object Foo {
  val foo = (number: Int) => Divisible.isMultipleOf(number, 2) match {case true => "Foo" case false => ""}
}
