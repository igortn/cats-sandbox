package functor

object FunctorOps {

  import cats.Functor

  /************************
   * See tests for examples
   ************************/

  /*
   * lift *** Lift a function to operate on functors.
   */
  val lenOption: Option[String] => Option[Int] = Functor[Option].lift(_.length)

}

