package traverse

import cats.implicits._

object Misc {

  /************  SEQUENCING ************/
  /*************************************/

  /* To transform things like List[Option[A]] into things like Option[List[A]],
   * we can traverse with the identity function. Alternatively, there is
   * a convenience method sequence that does exactly this.
   */

  val result1: Option[List[Int]] = List[Option[Int]](Some(1), Some(2), Some(3)).sequence

  val result2: Option[List[Int]] = List[Option[Int]](Some(1), None, Some(3)).sequence

  def check(): Unit = {
    assert(result1.contains(List(1,2,3)), "result1 should be equal to Some(List(1,2,3))")
    assert(result2.isEmpty, "result2 should be euqal to None")
  }

  // When traversing is done only to capture side-effects, and the actual values are not needed,
  // use traverse_ or sequence_. (They come from Foldable which is the parent of Traverse.)
}
