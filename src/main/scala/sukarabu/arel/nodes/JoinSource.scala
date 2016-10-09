package sukarabu.arel.nodes

import sukarabu.arel.Table

import scala.collection.mutable.ArrayBuffer

/**
  */
class JoinSource(var left: Option[Table], val right: ArrayBuffer[Node]) {
  def isEmpty: Boolean = left.isEmpty && right.isEmpty
  def nonEmpty: Boolean = !isEmpty
}
