package sukarabu.arel

import sukarabu.arel.nodes.{Node, SelectCore, SelectStatement}

/**
  */
abstract class TreeManager {
  val ctx: SelectCore

  def toSql: String = {
    ""
  }

  def where(expr: SelectStatement): TreeManager = {
    ctx.wheres.append(expr)
    this
  }
}
