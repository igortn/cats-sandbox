package functor

import functor.FunctorOps._
import org.scalatest.FlatSpec

class FunctorSpec extends FlatSpec {

  "lenOption(Some(\"abc\")" should "be equal to Some(3)" in {
    assert {
      lenOption(Some("abc")).contains(3)
    }
  }

  "lenOption(None)" should "be equal to None" in {
    assert {
      lenOption(None).isEmpty
    }
  }

  "tupleStrLenList [\"abc\", \"abcd\"]" should "be equal to [(\"abc\",3), (\"abcd\",4)]" in {
    assert {
      tupleStrLenList(List("John", "Lennon")) == List(("John",4), ("Lennon",6))
    }
  }
}
