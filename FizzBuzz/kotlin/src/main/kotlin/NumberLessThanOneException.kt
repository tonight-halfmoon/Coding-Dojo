class NumberLessThanOneException(integer: Int) : RuntimeException ("Expected `input` to be greater than 0, but found '$integer'") {
}
