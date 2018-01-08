package fpcourse


final case class ExactlyOne[A](a: A)

object ExactlyOne {

  def runExactlyOne[A](e: ExactlyOne[A]): A =
    e match {
      case ExactlyOne(a) => a
    }

  def mapExactlyOne[A, B](ea: ExactlyOne[A])(f: A => B): ExactlyOne[B] =
    ea match {
      case ExactlyOne(a) => ExactlyOne(f(a))
    }

  def bindExactlyOne[A, B](ea: ExactlyOne[A])(f: A => ExactlyOne[B]): ExactlyOne[B] =
    ea match {
      case ExactlyOne(a) => f(a)
    }
}
