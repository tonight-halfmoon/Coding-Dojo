filter = (input) => {
    if (0 === input % 3) {
	return "Fizz"
    }
    return ''
}

module.exports = { fizzFilter: filter }
