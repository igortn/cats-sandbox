package either

import cats.implicits._

/********************************************
  * Keep error ADTs local to each module
  * and have an application-wide error ADT
  * the wraps a local error ADT as needed.
  */

sealed abstract class DatabaseError
sealed abstract class ServiceError

sealed abstract class AppError

object AppError {
  final case class Database(error: DatabaseError)
  final case class Service(error: ServiceError)
}


/*******************************************
  * Define database and service modules.
  */

trait DatabaseValue

object Database {
  def databaseThings(): Either[DatabaseError, DatabaseValue] = ???
}

trait ServiceValue

object Service {
  def serviceThings(v: DatabaseValue): Either[ServiceError, ServiceValue] = ???
}


/**************************************************
  * In the app layer, we lift each module-specific
  * error into AppError by using Either.leftMap .
  */

object Application {

//  def doApp(): Either[AppError, ServiceValue] =
//    Database.databaseThings().leftMap(AppError.Database)
//    .flatMap(dbv => Service.serviceThings(dbv).leftMap(AppError.Service))

}
