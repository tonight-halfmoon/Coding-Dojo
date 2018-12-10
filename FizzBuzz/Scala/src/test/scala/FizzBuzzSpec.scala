import org.scalatest.FlatSpec
import org.scalatest.BeforeAndAfter

class FizzBizzSpec extends FlatSpec with BeforeAndAfter {

  before {
    FizzBuzz.addFilter(Buzz.buzz)
    FizzBuzz.addFilter(Fizz.fizz)
    FizzBuzz.addFilter(Foo.foo)
  }

  after {
    FizzBuzz.removeAllFilters()
    FizzBuzz.removeAllPrinters()
  }

  behavior of "`stringFor` when input is not divisible by 3 or 5"
  it should "return input" in {
    val input = 1
    val expected = 1.toString

    val actual = FizzBuzz.stringFor(input)

    assert(expected == actual)
  }

  behavior of "`stringFor` when input is less than 1"
  it should "throw IntegerLessThanOneException" in {
    assertThrows[IntegerLessThanOneException] {
      val input = 0

      FizzBuzz.stringFor(input)
    }
  }

  behavior of "`stringFor` when input is multiple of 3"
  it should "return 'Fizz'" in {
    val input = 3
    val expected = "Fizz"

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` when input is multiple of 5"
  it should "return 'Buzz'" in {
    val input = 5
    val expected = "Buzz"

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` when input is divisible by both 3 and 5"
  it should "return 'FizzBuzz'" in {
    val input = 15
    val expected = "FizzBuzz"

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` when input is divisible by 2"
  it should "return 'Foo'" in {
    val input = 2
    val expected = "Foo"

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` given list of integer and default printer"
  it should  "return result as a white space separated string for each integer's `divisibility`" in {
    val input = 1::(2::(3::(4::(5::(7::(15:: Nil))))))
    val expected = "1 Foo Fizz Foo Buzz 7 FizzBuzz"

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` given list of integer and CommaSeparated Printer"
  it should  "return result as a comma-separated string for each integer's `divisibility`" in {
    val input = 1::(2::(3::(4::(5::(7::(15:: Nil))))))
    val expected = "1, Foo, Fizz, Foo, Buzz, 7, FizzBuzz"
    FizzBuzz.addPrinter(CommaSeparatedPrinter.print)

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }

  behavior of "`stringFor` given list of integer and SemiColonSeparated Printer"
  it should  "return result as a Semicolon-separated string for each integer's `divisibility`" in {
    val input = 1::(2::(3::(4::(5::(7::(15:: Nil))))))
    val expected = "1; Foo; Fizz; Foo; Buzz; 7; FizzBuzz"
    FizzBuzz.addPrinter(SemicolonSeparatedPrinter.print)

    val actual = FizzBuzz.stringFor(input)

    assert(expected === actual)
  }
}
