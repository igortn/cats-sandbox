package free

import cats.free.Free

package object orders {
  type Symbol = String
  type Response = String

  type OrderF[A] = Free[Order, A]
}
