val CommaSeparatedPrinter = fun(value: List<Any>): String
{
	return value.fold("", { acc,
	it -> when (it)
	{
		is Int -> acc.plus(it.toString()).plus(", ")
		is String -> acc.plus(it).plus(", ")
		else -> acc
	}}).trim().trim(',')
}
