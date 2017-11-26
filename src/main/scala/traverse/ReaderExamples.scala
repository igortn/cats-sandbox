package traverse

import cats.data.Reader
import cats.implicits._

object ReaderExamples {

  // Some environment
  trait Context

  // Data bucket
  trait Topic

  trait Result

  // Reader[Context, A] is Kleisli[Id, Context, A], i.e. it's just a wrapper
  // around (Context => A).
  type Job[A] = Reader[Context, A]


  /*************** processing data and producing Reader(s) on Topic(s) *********/

  def processTopic(topic: Topic): Job[Result] = ???

  // Suppose, we have a data pipeline, and each piece of data falls into a topic.

  def processTopics(topics: List[Topic]): Job[List[Result]] =
    topics.traverse(processTopic)
}
