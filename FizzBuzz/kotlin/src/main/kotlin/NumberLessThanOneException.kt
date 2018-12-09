class NumberLessThanOneException(number: Int) : RuntimeException ("Expected `number` to be greater than 0, but found '$number'") {
}
