
object FizzBuzz {

  def fb(n: Int) : String = {
    return fb(n, isMultipleOf(n, 3))
  }

  def fb(n: Int, f: Boolean) : String = f match {
    case true => return "Fizz"
    case _ => return n.toString()
  }

  def isMultipleOf(n: Int, x: Int) : Boolean = {
    return 0 == n % x
  }
}
