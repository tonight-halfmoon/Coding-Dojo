val DefaultPrinter = fun(value: List<Any>): String
{
	return value.fold("", { acc,
	it -> when (it)
	{
		is Int -> acc + it.toString() + " "
		is String -> acc + it + " "
		else -> acc
	}}).trim()
}
