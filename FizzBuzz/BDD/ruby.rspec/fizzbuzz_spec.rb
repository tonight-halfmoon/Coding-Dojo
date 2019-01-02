require './fizzbuzz'
RSpec.describe FizzBuzz do
  describe "stringFor" do
    it "returns same 1 for an input" do
      fizzbuzz = FizzBuzz.new
      1.times { fizzbuzz.say(10) }
      expect(fizzbuzz.stringFor).to eq(1)
    end
  end
end
