filter = (input) => {
    return 0 === input % 5 ?
	"Buzz"
	:
	''
}

module.exports = { buzzFilter: filter }
