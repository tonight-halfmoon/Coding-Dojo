import org.scalatest.FlatSpec
import org.scalatest.BeforeAndAfter

class FizzBuzzKadaiSpec extends FlatSpec with BeforeAndAfter {

  before {
    val isMultipleOf = (number: Int, divisor: Int) => (number % divisor) match {case 0 => true case _ => false}
    val Fizz = (number: Int) => (0 == number % 3) match {case true => "Fizz" case _ => ""}
    val Buzz = (number: Int) => (0 == number % 5) match {case true => "Buzz" case _ => ""}
    FizzBuzz.addFilter(Fizz)
    FizzBuzz.addFilter(Buzz)
  }

  after {
    FizzBuzz.removeAllFilters()
  }

  behavior of "`stringFor` when input is less than 1"
  it should "throw Exception" in {
    assertThrows[Exception] {
      FizzBuzz.stringFor(0)
    }
  }

  behavior of "`stringFor` when input is divisible by 3"
  it should "return 'Fizz'" in {
    val input = 3
    val expected = "Fizz"

    val actual = FizzBuzz.stringFor(3)

    assert(expected === actual)
  }

  behavior of "`stringFor` when input is divisible by 3 and 5"
  it should "return 'FizzBuzz'" in {
    val input = 15
    val expected = "FizzBuzz"

    val actual = FizzBuzz.stringFor(15)

    assert(expected === actual)
  }

  behavior of "`stringFor` when input is divisible by 5"
  it should "return 'Buzz'" in {
    val input = 5
    val expected = "Buzz"

    val actual = FizzBuzz.stringFor(5)

    assert(expected === actual)
  }

  behavior of "`stringFor` when input is not divisible by 3 or 5"
  it should "return input" in {
    val input = 1
    val expected = 1

    val actual = FizzBuzz.stringFor(1)

    assert(expected === actual)
  }
}
