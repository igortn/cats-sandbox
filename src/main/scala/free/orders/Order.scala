package free.orders

import cats.free.Free._

sealed trait Order[A]
final case class Buy(stock: Symbol, amount: Int) extends Order[Response]
final case class Sell(stock: Symbol, amount: Int) extends Order[Response]
final case class ListStocks() extends Order[List[Symbol]]


object Order {
  def buy(stock: Symbol, amount: Int): OrderF[Response] =
    liftF(Buy(stock, amount))

  def sell(stock: Symbol, amount: Int): OrderF[Response] =
    liftF(Sell(stock, amount))

  def listStocks(): OrderF[List[Symbol]] =
    liftF(ListStocks())
}
