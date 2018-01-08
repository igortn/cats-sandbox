package kleisli

import cats.data.Kleisli

object Ex1 {
  def strToNonEmptyStr(s: String): Option[String] = s match {
    case null => None
    case "" => None
    case _ => Some(s)
  }

  def strToInt(s: String): Option[Int] =
    if (s.matches("[-]?[0-9]+"))
      Some(s.toInt)
    else
      None

  def div(n: Int, m: Int): Option[Double] =
    if (m == 0)
      None
    else
      Some(n.toDouble / m)

  def monadicWay(s1: String, s2: String): Option[Double] =
    for {
      ss1 <- strToNonEmptyStr(s1)
      n <- strToInt(ss1)

      ss2 <- strToNonEmptyStr(s2)
      m <- strToInt(ss2)

      d <- div(n, m)
    } yield d

  import cats.implicits._

  def kleisliWay(s1: String, s2: String): Option[Double] = {
    val o1 = Kleisli(strToNonEmptyStr _) andThen strToInt _ apply s1
    val o2 = Kleisli(strToNonEmptyStr _) andThen strToInt _ apply s2

    // not much win here, is it possible to do it with Kleisli?
    for {
      n <- o1
      m <- o2
      d <- div(n, m)
    } yield d
  }

  //  def kleislyWay(n: Int): Option[Int] =
  //    Kleisli(toStr _) andThen toInt _ andThen double _ apply n
}
