object FizzBuzz {

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

	private fun print(value: List<String>): String
	{
		val printers = PrintersProvider.all()
		val lastPrinter = printers.last()
		return lastPrinter(value)
	}
}
