package free.arithmetic

import cats.{~>, Id}

object Interpreter extends (Op ~> Id) {

  def apply[T](op: Op[T]): Id[T] = op match {
    case Num(n) =>
      n
    case Add(op1, op2) =>
      ???
    case Subtract(op1, op2) =>
      ???
    case Multiply(op1, op2) =>
      ???
    case Divide(op1, op2) =>
      ???
  }

}
