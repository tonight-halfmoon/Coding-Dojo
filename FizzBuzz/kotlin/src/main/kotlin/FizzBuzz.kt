object FizzBuzz {

	private var filters: MutableList<(Int) -> String> = mutableListOf()
	private var printers: MutableList<(List<Any>) -> Any> = mutableListOf()

	fun stringFor(input: List<Any>): Any
	{
		val result = input.map({ when(it)
		{
			is Int -> stringFor(it)
			else -> it
		}})
		return print(result)
	}

	fun stringFor(input: Int): Any
	{
		throwInputLessThanOneException(input)
		val result = process(input)
		return print(result)
	}

	fun addFilter(filter: (Int) -> String)
	{
		filters.add(filter)
	}

	fun removeAllFilters()
	{
		filters.clear()
	}

	fun addPrinter(printer: (List<Any>) -> Any)
	{
		printers.add(printer)
	}

	fun removeAllPrinters()
	{
		printers.clear()
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

	private fun print(value: List<Any>): Any
	{
		val lastPrinter = printers.last()
		return lastPrinter(value)
	}

	private fun print(value: Any): Any
	{
		return SimplePrinter(value)
	}
}
