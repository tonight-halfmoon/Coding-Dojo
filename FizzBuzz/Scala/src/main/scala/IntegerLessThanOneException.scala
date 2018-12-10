final case class IntegerLessThanOneException(
  private val message: String = None.orNull,
  private val cause: Throwable = None.orNull
)
    extends RuntimeException(IntegerLessThanOneException.defaultMessage(message), cause)

object IntegerLessThanOneException {
  def defaultMessage(message: String) =
    message match {
      case null =>
        "Input value less than one not acceptable."
      case _ =>
        message
    }
}
