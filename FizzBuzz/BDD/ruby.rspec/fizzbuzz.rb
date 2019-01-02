class FizzBuzz
  attr_accessor :input

  def say(input)
    @input = input
  end

  def stringFor
    @result = filter()
    if @result.nil?
      @input.to_s
    else
      @result
    end
  end

  def filter()
    if @input % 3 === 0
      'Fizz'
    elsif @input % 5 === 0
      'Buzz'
    else
      nil
    end
  end
end
