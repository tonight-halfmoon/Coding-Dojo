import org.scalatest.FlatSpec
import org.scalatest.BeforeAndAfter

class FizzBuzzKadaiSpec extends FlatSpec with BeforeAndAfter {

  before {
    FizzBuzz.addFilter(Fizz.fizz)
    FizzBuzz.addFilter(Buzz.buzz)
    FizzBuzz.addPrinter(DefaultPrinter.print _)
  }

  after {
    FizzBuzz.removeAllFilters()
    FizzBuzz.removeAllPrinters()
  }

  behavior of "`stringFor` when input is less than 1"
  it should "throw NumberLessThanOneException" in {
    assertThrows[IntegerLessThanOneException] {
      val input = 0

      FizzBuzz.stringFor(input)
    }
  }

  behavior of "`stringFor` when input is divisible by 3"
  it should "return 'Fizz'" in {
    val input = 3
    val expected = "Fizz"

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` when input is divisible by 3 and 5"
  it should "return 'FizzBuzz'" in {
    val input = 15
    val expected = "FizzBuzz"

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` when input is divisible by 5"
  it should "return 'Buzz'" in {
    val input = 5
    val expected = "Buzz"

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` when input is not divisible by 3 or 5"
  it should "return input as String" in {
    val input = 1
    val expected = "1"

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` given a list of integer and Default Printer"
  it should "return result as white separated string" in {
    val input = List(1,2,3,5)
    val expected = "1 2 Fizz Buzz"

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` given a list of intger and Comma Separated Printer"
  it should "return result as comma separated string" in {
    val input = List(1,2,3,5)
    val expected = "1, 2, Fizz, Buzz"
    val printer = CommaSeparatedPrinter.print _
    FizzBuzz.addPrinter(printer)

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` when input is divisible by 2"
  it should "return 'Foo'" in {
    val input = 2
    val expected = "Foo"
    val filter = Foo.foo
    FizzBuzz.addFilter(filter)

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }
}
