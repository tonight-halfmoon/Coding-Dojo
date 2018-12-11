object FizzBuzz {

	private var printers: MutableList<(List<String>) -> String> = mutableListOf()

	fun stringFor(input: List<Any>): String
	{
		val result = input.map({ when(it)
		{
			is Int -> stringFor(it)
			else -> ""
		}})
		return print(result)
	}

	fun stringFor(input: Int): String
	{
		val result = process(input)
		return print(listOf(result))
	}

	fun addPrinter(printer: (List<String>) -> String)
	{
		printers.add(printer)
	}

	fun removeAllPrinters()
	{
		printers.clear()
	}

	private fun process(input: Int): String
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

	private fun print(value: List<String>): String
	{
		val lastPrinter = printers.last()
		return lastPrinter(value)
	}
}
