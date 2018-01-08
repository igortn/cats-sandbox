package either

import cats.implicits._

object EitherStyleErrors {

  def parse(s: String): Either[NumberFormatException, Int] =
    if (s.matches("-?[0-9]+")) Either.right(s.toInt)
    else Either.left(new NumberFormatException(s"$s is not a valid integer"))

  def reciprocal(n: Int): Either[IllegalArgumentException, Double] =
    if (n == 0) Either.left(new IllegalArgumentException("division by 0"))
    else Either.right(1.0 / n)

  def magic(s: String): Either[Exception, String] =
    parse(s).flatMap(reciprocal).map(_.toString)
}
