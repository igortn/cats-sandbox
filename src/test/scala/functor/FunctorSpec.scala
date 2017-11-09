package functor

import org.scalatest.FlatSpec
import functor.FunctorOps._

class FunctorSpec extends FlatSpec {

  "lenOption(Some(\"abc\")" should "be equal to Some(3)" in {
    assert(
      lenOption(Some("abc")).contains(3)
    )
  }

  "lenOption(None)" should "be equal to None" in {
    assert(
      lenOption(None).isEmpty
    )
  }
}
