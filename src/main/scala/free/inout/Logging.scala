package free.inout

import cats.free.Free
import cats.free.Free.liftF

sealed trait Logging[A]
final case class Info(line: String) extends Logging[Unit]
final case class Warn(line: String) extends Logging[Unit]
final case class Error(line: String) extends Logging[Unit]
final case class Debug(line: String) extends Logging[Unit]

object Logging {
  def info(line: String): Free[Logging, Unit] =
    liftF(Info(line))
  def warn(line: String): Free[Logging, Unit] =
    liftF(Info(line))
  def error(line: String): Free[Logging, Unit] =
    liftF(Info(line))
  def debug(line: String): Free[Logging, Unit] =
    liftF(Info(line))
}