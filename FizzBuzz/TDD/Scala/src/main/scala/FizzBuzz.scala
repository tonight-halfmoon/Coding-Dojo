object FizzBuzz {

  def stringFor(input: Any): Any = {
    val result = process(input)
    print(result)
  }

  private def process(input: Any): Any = {
    ProcessJob.process(input)
  }

  private def print(value: Any): Any = {
    PrinterJob.print(value)
  }
}
