val Buzz: (Int) -> String = { number -> when(Divisible(number, 5)) { true -> "Buzz" else -> ""}}
