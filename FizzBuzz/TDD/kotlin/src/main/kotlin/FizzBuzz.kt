object FizzBuzz {

	fun stringFor(input: Any): String
	{
		val result = process(input)
		return print(result)
	}

	private fun process(input: Any): List<String>
	{
		return ProcessJob.process(input)
	}

	private fun print(value: List<String>): String
	{
		val printers = PrintersProvider.all()
		val lastPrinter = printers.last()
		return lastPrinter(value)
	}
}
