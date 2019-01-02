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

RSpec.describe FizzBuzz do
  describe "stringFor" do
    it "returns Fizz when input is 3" do
      fizzbuzz = FizzBuzz.new
      1.times { fizzbuzz.say(3) }
      expect(fizzbuzz.stringFor).to eq('Fizz')
    end
  end
end
