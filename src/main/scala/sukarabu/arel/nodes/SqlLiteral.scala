package sukarabu.arel.nodes

/**
  */
class SqlLiteral[A](val string: A) extends Node {
}

object SqlLiteral {
  def apply(string: String): SqlLiteral[String] = new SqlLiteral(string)
}
