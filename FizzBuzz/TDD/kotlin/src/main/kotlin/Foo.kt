val Foo: (Int) -> String = { number -> when(Divisible(number, 2)) { true -> "Foo" else -> ""}}
