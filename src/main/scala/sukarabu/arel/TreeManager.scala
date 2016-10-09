package sukarabu.arel

import sukarabu.arel.collectors.SqlString
import sukarabu.arel.nodes._

/**
  */
abstract class TreeManager {
  val ctx: SelectCore
  val ast: SelectStatement

  def toSql(engine: DatabaseEngine = Table.engine): String = {
    val collector = new SqlString
    engine.connection.visitor.visit(ast, collector)
    collector.value
  }

  def where(expr: Equality): TreeManager = {
    ctx.wheres.append(expr)
    this
  }
}
