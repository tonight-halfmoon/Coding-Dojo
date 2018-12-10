val SimplePrinter = fun(value: Any): Any {
    return when (value) {
        is Int -> value.toString()
        else -> value
    }
}
