object FizzBuzz {

	private var printers: MutableList<(List<String>) -> String> = mutableListOf()

	fun stringFor(input: List<Any>): String
	{
		val result = input.map({ when(it)
		{
			is Int -> ProcessJob.process(it)
			else -> ""
		}})
		return print(result)
	}

	fun stringFor(input: Int): String
	{
		val result = ProcessJob.process(input)
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

	private fun print(value: List<String>): String
	{
		val lastPrinter = printers.last()
		return lastPrinter(value)
	}
}
