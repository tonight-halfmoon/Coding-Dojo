package fizzbuzzkata

object FizzBuzz {
    fun stringFor(input: Any): String
        {
		throwIntegerLessThanOneException(input)
		return input.toString()
        }

	private fun throwIntegerLessThanOneException(input: Any) {
		when (input) {
			is Int ->
			if ( 1 > input) {
				throw IntegerLessThanOneException(input)
			}
			else
			Any()
		}
	}
}

fun main(args: Array<String>) {
    println(FizzBuzz.stringFor(args))
}
