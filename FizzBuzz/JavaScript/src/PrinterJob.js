printFun = (input, result) => {
    const resultAsString = Array.from(result).join(' ').trim(' ')
    if('' === resultAsString)
    {
	return input.toString()
    }
    return resultAsString
}

module.exports = {printerJob: { process: printFun } }
