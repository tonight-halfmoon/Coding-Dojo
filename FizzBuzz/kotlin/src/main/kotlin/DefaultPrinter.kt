val DefaultPrinter = fun(value: Any): String
{
	return when(value)
	{
		is List<*> ->
		value.fold("", { acc, it -> when (it)
		{
			is Int -> acc + it.toString() + " "
			is String -> acc + it + " "
			else -> acc
		}}).trim()

		else ->	value.toString()
	}
}
