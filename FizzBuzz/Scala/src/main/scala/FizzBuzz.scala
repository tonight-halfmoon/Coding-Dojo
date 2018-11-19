
object FizzBuzz {

  def fb(n: Int) : String = {
    return fb(n, isMultipleOf(n, 3), isMultipleOf(n, 5))
  }

  def fb(n: Int, f: Boolean, b: Boolean) : String = (n, f, b) match {
    case (n, _, _) if 1 > n => throw new Exception("Expected Number > 1")
    case (_, true, false) => return "Fizz"
    case (_, false, true) => return "Buzz"
    case (_, true, true) => return "FizzBuzz"
    case _ => return n.toString()
  }

  def isMultipleOf(n: Int, x: Int) : Boolean = {
    return 0 == n % x
  }
}
