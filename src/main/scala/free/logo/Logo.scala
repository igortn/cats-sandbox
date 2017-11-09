package free.logo

import cats.free.Free

sealed trait Instruction[A]
case class Forward(position: Position, length: Int) extends Instruction[Position]
case class Backward(position: Position, length: Int) extends Instruction[Position]
case class RotateLeft(position: Position, degree: Degree) extends Instruction[Position]
case class RotateRight(position: Position, degree: Degree) extends Instruction[Position]
case class ShowPosition(position: Position) extends Instruction[Unit]

case class Position(x: Double, y: Double, heading: Degree)
case class Degree(private val d: Int) {
  val value: Int = d % 360
}

object Logo {
  def forward(pos: Position, l: Int): Free[Instruction, Position] =
    Free.liftF(Forward(pos, l))
  def backward(pos: Position, l: Int): Free[Instruction, Position] =
    Free.liftF(Backward(pos, l))
  def left(pos: Position, degree: Degree): Free[Instruction, Position] =
    Free.liftF(RotateLeft(pos, degree))
  def right(pos: Position, degree: Degree): Free[Instruction, Position] =
    Free.liftF(RotateRight(pos, degree))
  def showPosition(pos: Position): Free[Instruction, Unit] =
    Free.liftF(ShowPosition(pos))

  val exampleProgram: Position => Free[Instruction, Position] =
    start => for {
      p1 <- forward(start, 10)
      p2 <- right(p1, Degree(90))
      p3 <- forward(p2, 10)
    } yield p3
}
