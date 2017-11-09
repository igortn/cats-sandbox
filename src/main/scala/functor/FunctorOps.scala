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

object Test {
  import FunctorOps._

  def run(): Unit = {
    assert(lenOption(Some("abc")).contains(3))
    assert(lenOption(None).isEmpty)

    println("assertions passed ...")
  }
}
