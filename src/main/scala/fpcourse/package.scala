import cats.{Applicative, Functor}
import fpcourse.ExactlyOne.mapExactlyOne

package object fpcourse {

  /**
    * Attempt to translate Tony Morris' Haskell "fp-course" into Scala with Cats.
    */

  implicit val functorInstanceForExactlyOne: Functor[ExactlyOne] = new Functor[ExactlyOne] {
    override def map[A, B](fa: ExactlyOne[A])(f: A => B): ExactlyOne[B] =
      mapExactlyOne(fa)(f)
  }

  implicit val applicativeInstanceForExactlyOne: Applicative[ExactlyOne] = new Applicative[ExactlyOne] {
    override def pure[A](x: A): ExactlyOne[A] = ???

    override def ap[A, B](ff: ExactlyOne[A => B])(fa: ExactlyOne[A]): ExactlyOne[B] = ???
  }
}
