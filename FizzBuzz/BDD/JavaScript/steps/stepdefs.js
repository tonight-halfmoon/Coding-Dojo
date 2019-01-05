const { Given, When, Then } = require("cucumber")

const { expect } = require("chai")

const fizzBuzz = require("./index").fizzBuzz

Given("Input is {int}", function(input) {
  this.input = input
})

When("I ask what's that", function() {
  this.actual = fizzBuzz.stringFor(this.input)
})

Then("I should be told {string}", function(expected) {
  expect(this.actual).to.eql(expected)
})
