import org.scalatest.FlatSpec

class FizzBuzzKadaiSpec extends FlatSpec {

  val Fizz = (number: Int) => (0 == number % 3) match {case true => "Fizz" case _ => ""}
  val Buzz = (number: Int) => (0 == number % 5) match {case true => "Buzz" case _ => ""}

  FizzBuzz.addFilter(Fizz)
  FizzBuzz.addFilter(Buzz)

  behavior of "`stringFor` when number is less than 1"
  it should "throw Exception" in {
    assertThrows[Exception] {
      FizzBuzz.stringFor(0)
    }
  }

  behavior of "`stringFor` when number is divisible by 3"
  it should "return 'Fizz'" in {
    assert("Fizz" === FizzBuzz.stringFor(3))
  }

  behavior of "`stringFor` when number is divisible by 3 and 5"
  it should "return 'FizzBuzz'" in {
    assert("FizzBuzz" === FizzBuzz.stringFor(15))
  }
}
