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
}
