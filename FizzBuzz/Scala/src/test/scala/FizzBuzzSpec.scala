import org.scalatest.FlatSpec

class FizzBuzzKadaiSpec extends FlatSpec {

  val Fizz = (number: Int) => (0 == number % 3) match {case true => "Fizz" case _ => ""}

  FizzBuzz.addFilter(Fizz)

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
}
