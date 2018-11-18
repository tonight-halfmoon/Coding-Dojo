import org.scalatest.FlatSpec

class FizzBuzzSpec extends FlatSpec {

  behavior of "Number not multiple of 3 or 5"

  it should "return number" in {
    assert("n" === FizzBuzz.fb(1))
  }
}
