object ProcessJob {
	fun process(input: Int): String
	{
		throwInputLessThanOneException(input)
		val result = applyFilters(input)
		return when (result.isEmpty())
		{
			true -> input.toString()
			else -> result
		}
	}

	private fun applyFilters(input: Int): String
	{
		val filters = FiltersProvider.all()
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
