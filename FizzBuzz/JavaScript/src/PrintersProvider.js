let defprinter = require('./DefaultPrinter').printer

class PrintersProvider {
    configure(printer) {
	defprinter = printer
    }

    available() {
	return defprinter
    }
}

module.exports = { printersProvider: new PrintersProvider() }
