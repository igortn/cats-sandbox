package free.arithmetic

sealed trait Op[+T]
case class Num(n: Int) extends Op[Int]
case class Add(op1: Op[Int], op2: Op[Int]) extends Op[Int]
case class Subtract(op1: Op[Int], op2: Op[Int]) extends Op[Int]
case class Multiply(op1: Op[Int], op2: Op[Int]) extends Op[Int]
case class Divide(op1: Op[Int], op2: Op[Int]) extends Op[Either[Error, Int]]

case class Error(msg: String)

object Op {
  import cats.free.Free
  import cats.free.Free.liftF

  def num(n: Int): Free[Op, Int] =
    liftF(Num(n))

  def add(op1: Op[Int], op2: Op[Int]): Free[Op, Int] =
    liftF(Add(op1, op2))

  def subtract(op1: Op[Int], op2: Op[Int]): Free[Op, Int] =
    liftF(Subtract(op1, op2))

  def multiply(op1: Op[Int], op2: Op[Int]): Free[Op, Int] =
    liftF(Multiply(op1, op2))

  def divide(op1: Op[Int], op2: Op[Int]): Free[Op, Either[Error, Int]] =
    liftF(Divide(op1, op2))
}