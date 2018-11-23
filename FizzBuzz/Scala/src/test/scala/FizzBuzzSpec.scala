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
    val input = 3
    val expected = "Fizz"

    val actual = FizzBuzz.stringFor(3)

    assert(expected === actual)
  }

  behavior of "`stringFor` when number is divisible by 3 and 5"
  it should "return 'FizzBuzz'" in {
    val input = 15
    val expected = "FizzBuzz"

    val actual = FizzBuzz.stringFor(15)

    assert(expected === actual)
  }

  behavior of "`stringFor` when number is divisible by 5"
  it should "return 'Buzz'" in {
    val input = 5
    val expected = "Buzz"

    val actual = FizzBuzz.stringFor(5)

    assert(expected === actual)
  }

  behavior of "`stringFor` when number is not divisible by 3 or 5"
  it should "return number" in {
    val input = 1
    val expected = 1

    val actual = FizzBuzz.stringFor(1)

    assert(expected === actual)
  }
}
