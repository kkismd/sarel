package sukarabu.arel.nodes

import scala.collection.mutable.ArrayBuffer

/**
  */
class SelectCore extends Node {
  val wheres = ArrayBuffer.empty[SelectStatement]
}
