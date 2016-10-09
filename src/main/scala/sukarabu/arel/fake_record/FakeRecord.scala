package sukarabu.arel.fake_record

import sukarabu.arel.DatabaseEngine
import sukarabu.arel.visitors.ToSql

/**
  */
class Connection {
  val visitor = new ToSql
}

class ConnectionPool {
  val connection = new Connection
}

class Base extends DatabaseEngine {
  val connectionPool = new ConnectionPool
  val connection: Connection = connectionPool.connection
}

