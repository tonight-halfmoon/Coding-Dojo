require './fizzbuzz'
RSpec.describe FizzBuzz do
  describe "stringFor" do
    it "returns same input as String for an input" do
      fizzbuzz = FizzBuzz.new
      1.times { fizzbuzz.say(1) }
      expect(fizzbuzz.stringFor).to eq('1')
    end
  end
end

RSpec.describe FizzBuzz do
  describe "stringFor" do
    it "returns 'Fizz' when input is divisible 3" do
      fizzbuzz = FizzBuzz.new
      1.times { fizzbuzz.say(3) }
      expect(fizzbuzz.stringFor).to eq('Fizz')
    end
  end
end

RSpec.describe FizzBuzz do
  describe "stringFor" do
    it "returns 'Buzz' when input is divisible 5" do
      fizzbuzz = FizzBuzz.new
      1.times { fizzbuzz.say(5) }
      expect(fizzbuzz.stringFor).to eq('Buzz')
    end
  end
end
