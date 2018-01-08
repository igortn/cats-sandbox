package object either {

// This is not needed anymore because cats already implements
//  the implicit for Either monad.

/*********************************************************************/

//  import cats.implicits._
//  import cats.Monad
//
//  // "?" is a syntax for type lambda translated by the kind projector
//  implicit def eitherMonad[Err]: Monad[Either[Err, ?]] =
//    new Monad[Either[Err, ?]] {
//
//      override def pure[A](x: A): Either[Err, A] = Either.right(x)
//
//      override def flatMap[A, B](fa: Either[Err, A])(f: A => Either[Err, B]): Either[Err, B] =
//        fa.flatMap(f)
//
//
//      // Cats now requires to implement stack safe monadic recursion,
//      // as described in "Stack Safety for Free" by Phil Freeman
//      @annotation.tailrec
//      def tailRecM[A, B](a: A)(f: A => Either[Err, Either[A, B]]): Either[Err, B] =
//        f(a) match {
//          case Left(error) => Left(error)
//          case Right(Left(nextA)) => tailRecM(nextA)(f)
//          case Right(Right(b)) => Right(b)
//        }
//    }

}
