package free.orders

import cats.implicits._
import Order._

object Programs {

  val trade1: OrderF[Response] = for {
    _ <- buy("APPL", 50)
    _ <- sell("GOOG", 100)
    resp <- buy("MSFT", 100)
  } yield resp

  val trade2: OrderF[List[Response]] = for {
    stocks <- listStocks()
    resp <- stocks.traverse(buy(_, 100))
  } yield resp
}
