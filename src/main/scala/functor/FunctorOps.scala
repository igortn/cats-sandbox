package functor

object FunctorOps {

  import cats.Functor

  /** ************************************************************
    * The implicit instances of Functor[Option] and Functor[List]
    * are defined in the package object.
    *
    * See the tests for examples.
    * ************************************************************/


  /*
   * lift *** Lift a function to operate on functors.
   */
  val lenOption: Option[String] => Option[Int] = Functor[Option].lift(_.length)

  /*
   * void *** Remove the values but preserve the structure
   */
  val voidList: List[Int] => List[Unit] = Functor[List].void(_)


  /*
   * fproduct *** Tuple the values with the results of applying a function
   */
  val tupleStrLenList: List[String] => List[(String,Int)] =
    Functor[List].fproduct(_)((s: String) => s.length)
}

