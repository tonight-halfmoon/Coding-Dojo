class FizzBuzz
  attr_accessor :input

  def say(input)
    @input = input
  end

  def stringFor
    @result = filter(@input)
    if @result.empty?
      @input.to_s
    else
      @result
    end
  end

  def filter(input)
    @result = fizzFilter(input)
    @result += buzzFilter(input)
    @result
  end

  def fizzFilter(integer)
    if integer % 3 === 0
      'Fizz'
    else
      ''
    end
  end

  def buzzFilter(integer)
    if integer % 5 === 0
      'Buzz'
    else
      ''
    end
  end
end
