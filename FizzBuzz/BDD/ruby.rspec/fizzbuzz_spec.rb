require './fizzbuzz'
RSpec.describe FizzBuzz do
  describe "stringFor" do
    it "returns same input as String for an input" do
      fizzbuzz = FizzBuzz.new
      1.times { fizzbuzz.say(10) }
      expect(fizzbuzz.stringFor).to eq('10')
    end
  end
end
