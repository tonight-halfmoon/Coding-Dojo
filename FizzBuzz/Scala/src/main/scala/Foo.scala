object Foo {
  def foo = (number: Int) => (Divisible.isMultipleOf(number, 2)) match {case true => "Foo" case _ => ""}
}
