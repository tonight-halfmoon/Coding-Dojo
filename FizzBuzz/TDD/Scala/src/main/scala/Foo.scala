object Foo {
  def foo = (integer: Int) => Divisible.isMultipleOf(integer, 2) match {
    case true => "Foo"
    case _ => ""
  }
}
