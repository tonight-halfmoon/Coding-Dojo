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
		val stringForInput = applyFilters(input)
		return when (stringForInput.isEmpty())
		{
			true -> input
			else -> stringForInput
		}
	}

	private fun applyFilters(input: Int): String
	{
		return applyFilters(input, filters, "")
	}

	private tailrec fun applyFilters(input: Int, filters: MutableList<(Int) -> String>, stringForInput: String): String
	{
		return when (filters.isEmpty()) {
			true -> stringForInput
			else -> {
				val nextFilter = filters.first()
				filters.remove(nextFilter)
				applyFilters(input, filters, stringForInput.plus(nextFilter(input)))
			}
		}
	}

	private fun throwInputLessThanOneException(input: Int)
	{
		if (input < 1) {
			throw NumberLessThanOneException(input)
		}
	}
}
