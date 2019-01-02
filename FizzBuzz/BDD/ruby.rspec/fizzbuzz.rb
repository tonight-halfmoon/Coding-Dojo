class FizzBuzz
  attr_accessor :input

  def say(input)
    @input = input
  end

  def stringFor
    @result = filter()
    if @result.empty?
      @input.to_s
    else
      @result
    end
  end

  def filter()
    @result = fizzFilter(@input)
    if @input % 5 === 0
      @result += 'Buzz'
    else
      ''
    end
    @result
  end

  def fizzFilter(integer)
    if @input % 3 === 0
      'Fizz'
    else
      ''
    end
  end
end
