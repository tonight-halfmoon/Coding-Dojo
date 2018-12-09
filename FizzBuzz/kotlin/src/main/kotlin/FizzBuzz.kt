object FizzBuzz {

	private var filters: MutableList<(Int) -> String> = mutableListOf()

	fun stringFor(input: List<Any>): Any
	{
		return input.map({
			when(it)
			{
				is Int -> stringFor(it)
				else -> it
			}
		}).fold("", { acc,
		it -> when (it)
		{
			is Int -> acc + it.toString() + " "
			is String -> acc + it + " "
			else -> acc
		}}).trim()
	}

	fun stringFor(input: Int): Any
	{
		throwInputLessThanOneException(input)
		return process(input)
	}

	fun addFilter(filter: (Int) -> String)
	{
		filters.add(filter)
	}

	fun removeAllFilters()
	{
		filters.clear()
	}

	private fun process(input: Int): Any
	{
		val result = applyFilters(input)
		return when (result.isEmpty())
		{
			true -> input
			else -> result
		}
	}

	private fun applyFilters(input: Int): String
	{
		return applyFilters(input, filters.toMutableList(), "")
	}

	private tailrec fun applyFilters(input: Int, filters: MutableList<(Int) -> String>, result: String): String
	{
		return when (filters.isEmpty()) {
			true -> result
			else -> {
				val nextFilter = filters.first()
				filters.remove(nextFilter)
				applyFilters(input, filters, result.plus(nextFilter(input)))
			}
		}
	}

	private fun throwInputLessThanOneException(input: Int)
	{
		if (input < 1) {
			throw IntegerLessThanOneException(input)
		}
	}
}
