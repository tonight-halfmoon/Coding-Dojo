const printersProvider = require('./PrintersProvider').printersProvider

printFun = (result) => {
    if(result instanceof Array) {
	const printer = printersProvider.available()
	const resultAsString = Array.from(result).join(printer()).trim(' ')
	return resultAsString
    }
    return result
}

module.exports = {printerJob: { process: printFun } }
