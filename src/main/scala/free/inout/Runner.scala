package free.inout

import cats.free.Free
import cats.{Id, ~>}

object Runner {

  def run[A](program: Free[InOut, A])(interpreter: InOut ~> Id): A =
    program.foldMap(interpreter)

}

object Programs {
  import free.inout.InOut.{getLine, printLine}

  def program1: Free[InOut, Unit] =
    for {
      _ <- printLine("Who are you?")
      name <- getLine
      _ <- printLine(s"Hello, $name!")
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
