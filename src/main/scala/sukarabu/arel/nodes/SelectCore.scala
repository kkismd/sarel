package sukarabu.arel.nodes

import scala.collection.mutable.ArrayBuffer

/**
  */
class SelectCore extends Node {
  val source = new JoinSource(None, ArrayBuffer.empty[Node])
  val wheres = ArrayBuffer.empty[Equality]
  val projections = ArrayBuffer.empty[SqlLiteral[String]]
}
