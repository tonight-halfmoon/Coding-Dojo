object FizzBuzz {

	private var filters: MutableList<(Int) -> String> = mutableListOf()

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
		return applyFilters(input, filters, "")
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
