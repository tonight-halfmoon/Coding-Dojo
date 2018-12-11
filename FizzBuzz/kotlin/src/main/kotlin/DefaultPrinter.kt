val DefaultPrinter = fun(value: List<String>): String
{
	return value.fold("", { acc, it -> acc.plus(it).plus(" ")}).trim()
}
