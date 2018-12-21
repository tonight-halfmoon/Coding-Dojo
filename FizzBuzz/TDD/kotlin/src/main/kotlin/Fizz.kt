val Fizz: (Int) -> String = { number -> when(Divisible(number, 3)) { true -> "Fizz" else -> ""}}
