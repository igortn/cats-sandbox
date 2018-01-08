package free.orchestration

import cats.free.Free
import cats.free.Free._

object Domain {

  final case class Tweet(userId: UserId, msg: String)
  final case class User(id: UserId, name: UserName, photo: UserPhoto)

  sealed trait Service[A]
  final case class GetTweets(userId: UserId) extends Service[List[Tweet]]
  final case class GetUserName(userId: UserId) extends Service[UserName]
  final case class GetUserPhoto(userId: UserId) extends Service[UserPhoto]

  sealed trait Request[A]
  final case class Pure[A](a: A) extends Request[A]
  final case class Fetch[A](service: Service[A]) extends Request[A]

  object Request {
    def pure[A](a: A): Free[Request, A] =
      liftF(Pure(a))

    def fetch[A](service: Service[A]): Free[Request, A] =
      liftF(Fetch(service))
  }
}
