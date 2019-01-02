class FizzBuzz
  attr_accessor :input

  def say(input)
    @input = input
  end

  def stringFor
    @result = filter(@input)
    @result.empty? ?
      @input.to_s
    :
      @result
  end

  def filter(input)
    @result = fizzFilter(input)
    @result.concat(buzzFilter(input))
    @result
  end

  def fizzFilter(integer)
    integer % 3 === 0 ?
      'Fizz'
    :
      ''
  end

  def buzzFilter(integer)
    integer % 5 === 0 ?
      'Buzz'
    :
      ''
  end
end
