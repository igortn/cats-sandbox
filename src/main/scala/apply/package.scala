package object apply {

  import cats.Apply

  implicit val optionApplyInst: Apply[Option] = new Apply[Option] {

    override def ap[A, B](ff: Option[A => B])(fa: Option[A]): Option[B] =
      fa.flatMap { a => ff.map(g => g(a)) }

    override def map[A, B](fa: Option[A])(f: A => B): Option[B] =
      fa.map(f)
  }

  implicit val listApplyInst: Apply[List] = new Apply[List] {

    override def ap[A, B](ff: List[A => B])(fa: List[A]): List[B] =
      fa.flatMap { a => ff.map(g => g(a)) }

    override def map[A, B](fa: List[A])(f: A => B): List[B] =
      fa.map(f)
  }
}
