package free

import cats.data.EitherK

package object inout {

  type Eff[A] = EitherK[InOut, Logging, A]

}
