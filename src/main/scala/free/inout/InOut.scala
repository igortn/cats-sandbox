package free.inout

import cats.free.Free

sealed trait InOut[A]
case class PrintLine(line: String) extends InOut[Unit]
case object GetLine extends InOut[String]

object InOut {
  import cats.free.Free.liftF

  def printLine(line: String): Free[InOut, Unit] =
    liftF(PrintLine(line))

  def getLine: Free[InOut, String] =
    liftF(GetLine)
}