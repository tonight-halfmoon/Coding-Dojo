const filterJob = require("./FilterJob").filterJob

class FizzBuzz {
  stringFor(input) {
    const result = filterJob.filter(input)
    if (result === "") {
      return input.toString()
    }
    return result
  }
}

module.exports = { fizzBuzz: new FizzBuzz() }
