package free

package object kvstore {
  import cats.free.Free

  type KVStore[A] = Free[KVStoreA, A]
}
