package free.orders

import cats.{Id, ~>}

object Interpreter {

  def orderPrinter: Order ~> Id = new ~>[Order, Id] {
    override def apply[A](fa: Order[A]): Id[A] = fa match {
      case Buy(stock, amount) =>
        println(s"Buying $amount of $stock")
        "OK"
      case Sell(stock, amount) =>
        println(s"Selling $amount of $stock")
        "OK"
    }
  }

}

/**********************************************************
  **
  **  Execute a program using this interpreter.
  **
  **  def program = for {
  **    _ <- buy("GOOG", 100)
  **    r <- sell("APPL", 100)
  **  } yield r
  **
  **  program.foldMap(orderPrinter)
  **
  *********************************************************/

