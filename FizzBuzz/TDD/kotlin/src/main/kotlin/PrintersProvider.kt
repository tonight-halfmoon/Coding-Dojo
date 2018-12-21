object PrintersProvider {

	private val printers: MutableList<(List<String>) -> String> = mutableListOf()

	fun add(printer: (List<String>) -> String)
	{
		printers.add(printer)
	}

	fun removeAll()
	{
		printers.clear()
	}

	fun all(): MutableList<(List<String>) -> String>
	{
		return printers.toMutableList()
	}
}
