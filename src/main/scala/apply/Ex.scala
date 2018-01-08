package apply

import cats.Apply

object Ex {

  val triple: Int => Int = _ * 3

  val res1 = Apply[Option].map(Some(7))(triple)

  val res2 = Apply[Option].ap(Some(triple))(Some(11))
  val res3 = Apply[Option].ap(None)(Some(11))

  // Apply instances compose
  val listOpt = Apply[List] compose Apply[Option]

  val res4 = listOpt.ap(List(Some(triple), None))(List(Some(1), None, Some(3)))

  def test(): Unit = {
    assert(res1.contains(21))

    assert(res2.contains(33))
    assert(res3.isEmpty)

    assert(res4 == List(Some(3), None, None, None, Some(9), None))
  }
}
