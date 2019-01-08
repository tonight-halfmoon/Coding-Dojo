package fizzbuzzkata

object FizzBuzz {
    fun stringFor(input: Any): String
        {
		return input.toString()
        }
}

fun main(args: Array<String>) {
    println(FizzBuzz.stringFor(args))
}
