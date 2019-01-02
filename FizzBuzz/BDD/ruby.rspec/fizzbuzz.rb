class FizzBuzz
  attr_accessor :input

  def say(input)
    @input = input
  end

  def stringFor
    if @input === 3
      'Fizz'
    elsif @input === 5
      'Buzz'
    else
      @input.to_s
    end
  end
end
