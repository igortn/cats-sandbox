package free.inout

import cats.free.Free
import cats.{Id, ~>}

object Runner {

  def run[A](program: Free[InOut,Id[A]])(interpreter: InOut ~> Id): Id[A] =
    program.foldMap(interpreter)

}

object Programs {
  import free.inout.InOut.{getLine, printLine}

  def program1: Free[InOut, Unit] =
    for {
      _ <- printLine("who are you?")
      name <- getLine
      _ <- printLine(s"hi there, $name")
    } yield ()
}

object ConsoleInterpreter extends (InOut ~> Id) {

  def apply[A](inout: InOut[A]): Id[A] = inout match {
    case PrintLine(line) =>
      println(line)
    case GetLine =>
      scala.io.StdIn.readLine()
  }

}
