object FiltersProvider {
	private var filters: MutableList<(Int) -> String> = mutableListOf()

	fun add(filter: (Int) -> String)
	{
		filters.add(filter)
	}

	fun removeAll()
	{
		filters.clear()
	}

	fun all(): MutableList<(Int) -> String>
	{
		return filters.toMutableList()
	}
}
