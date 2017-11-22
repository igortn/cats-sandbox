/**
  * A unit test supported by a special interpreter for a Free Monad based program.
  */

package free.inout

import cats.{Id, ~>}
import org.scalatest.FlatSpec

import scala.collection.mutable.ListBuffer
import scala.collection.{mutable => m}

class InOutSpec extends FlatSpec {

  def testInterpreter(input: String, output: m.ListBuffer[String]): (InOut ~> Id) =
    new (InOut ~> Id) {
      override def apply[A](inout: InOut[A]): Id[A] = inout match {
        case PrintLine(line) =>
          output += line
          ()
        case GetLine =>
          input
      }
    }

  "program1" should "ask for a name and greet the user" in {
    val output = m.ListBuffer.empty[String]

    Runner.run(Programs.program1)(testInterpreter("John", output))

    assert {
      output == ListBuffer("Who are you?", "Hello, John!")
    }
  }

}
