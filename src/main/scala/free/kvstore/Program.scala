package free.kvstore

object Program {
  import free.kvstore.Ops._

  def program: KVStore[Option[Int]] =

    for {
      _ <- put("one", 1)
      _ <- put("two", 2)
      _ <- put("three", 3)
      _ <- update[Int]("two", _ + 10)
      n <- get[Int]("two")
    } yield n
}

object Computation {
  import cats._
  //import cats.implicits._
  import scala.collection.mutable

  def impureCompiler: KVStoreA ~> Id = new ~>[KVStoreA, Id] {
    val kvs = mutable.Map.empty[String, Any]

    override def apply[A](fa: KVStoreA[A]): Id[A] = fa match {
      case Put(key, value) =>
        println(s"put($key, $value)")
        kvs(key) = value
        ()
      case Get(key) =>
        println(s"get($key)")
        kvs.get(key).map(_.asInstanceOf[A])
      case Delete(key) =>
        println(s"delete($key)")
        kvs.remove(key)
        ()
    }
  }
}