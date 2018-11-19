object FizzBuzz {

  def stringFor(number: Int): Any =
  {
    throwNumberLessThanOneException(number)
    return number
  }

  private def throwNumberLessThanOneException(number: Int): Any =
    (1 > number) match {
      case true =>
        throw new NumberLessThanOneException(number)
      case _ =>
        ;
    }
}
