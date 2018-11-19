import org.scalatest.FlatSpec

class FizzBuzzKadaiSpec extends FlatSpec {

  behavior of "`stringFor` when number is less than 1"
  it should "throw Exception" in {
    assertThrows[Exception] {
      FizzBuzz.stringFor(0)
    }
  }
}
