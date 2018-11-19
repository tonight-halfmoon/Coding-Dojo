
object FizzBuzz {

  def fb(n: Int) : String = {
    return fb(n, isMultipleOf(n, 3), isMultipleOf(n, 5))
  }

  def fb(n: Int, f: Boolean, b: Boolean) : String = (f, b) match {
    case (true, false) => return "Fizz"
    case (false, true) => return "Buzz"
    case _ => return n.toString()
  }

  def isMultipleOf(n: Int, x: Int) : Boolean = {
    return 0 == n % x
  }
}
