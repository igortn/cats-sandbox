package traverse

import cats.implicits._

object EitherExamples {

  def parseIntEither(s: String): Either[NumberFormatException, Int] =
    Either.catchOnly[NumberFormatException](s.toInt)

  val result1: Either[NumberFormatException, List[Int]] = List("1", "2", "3").traverse(parseIntEither)

  val result2: Either[NumberFormatException, List[Int]] = List("1", "abc", "3").traverse(parseIntEither)

  def check(): Unit = {
    assert(result1.right.get == List(1,2,3), "result1 should wrap List(1,2,3)")
    assert(result2.isLeft, "result2 wraps exception and should be left bound")
  }
}
