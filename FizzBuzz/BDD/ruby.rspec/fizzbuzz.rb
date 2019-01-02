class FizzBuzz
  attr_accessor :input

  def say(input)
    @input = input
  end

  def stringFor
   if @input === 3
      'Fizz'
    else
     @input.to_s
   end
  end
end
