class FizzBuzz
  attr_accessor :input
  def say(input)
    @input = input
  end

  def stringFor
     @input.to_s
  end
end
