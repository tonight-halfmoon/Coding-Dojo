
object FizzBuzz {

	private var filters: MutableList<(Int) -> String> = mutableListOf()
	
	fun stringFor(number: Int): Any
	{
		throwNumberLessThanOneException(number)
		return convert(number)
	}

	fun addFilter(filter: (Int) -> String)
	{
		filters.add(filter)
	}

	fun removeAllFilters()
	{
		filters.clear()
	}

	private fun convert(number: Int): Any
	{
		val stringForNumber = applyFilters(number)
		return when (stringForNumber.isEmpty())
		{
			true -> number
			else -> stringForNumber 
		}
	}

	private fun applyFilters(number: Int): String
	{
		return applyFilters(number, filters, "")
	}

	private tailrec fun applyFilters(number: Int, filters: MutableList<(Int) -> String>, stringForNumber: String): String
	= if (filters.isEmpty()) {
		stringForNumber
	}
	else
	{
		val nextFilter = filters.first()
		filters.remove(nextFilter)
		applyFilters(number, filters, stringForNumber.plus(nextFilter(number)))
	}

	private fun throwNumberLessThanOneException(number: Int)
	{
		if (number < 1) {
			throw NumberLessThanOneException(number)
		}
	}
}

class NumberLessThanOneException(number: Int) : RuntimeException ("Expected `number` to be greater than 0, but found '$number'") {
	
}
