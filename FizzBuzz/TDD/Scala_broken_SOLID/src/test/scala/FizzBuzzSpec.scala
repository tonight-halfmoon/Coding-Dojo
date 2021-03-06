import org.scalatest.FlatSpec

class FizzBuzzSpec extends FlatSpec {

  behavior of "Number not multiple of 3 or 5"

  it should "return number" in {
    assert("1" === FizzBuzz.fb(1))
  }

  behavior of "Number multiple of 3"
  it should "return 'Fizz'" in {
    assert("Fizz" === FizzBuzz.fb(3))
  }

  behavior of "Number multiple of 5"

  it should "return 'Buzz'" in {
    assert("Buzz" === FizzBuzz.fb(5))
  }

  behavior of "Number multiple of both 3 and 5"

  it should "return 'FizzBuzz'" in {
    assert("FizzBuzz" === FizzBuzz.fb(15))
  }

  behavior of "Number less than 1"

  it should "throw Exception" in {
    assertThrows[Exception] {
      FizzBuzz.fb(0)
    }
  }
}
