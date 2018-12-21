printFun = (result) => {
    if(result instanceof Array) {
	const resultAsString = Array.from(result).join(' ').trim(' ')
	return resultAsString
    }
    return result
}

module.exports = {printerJob: { process: printFun } }
