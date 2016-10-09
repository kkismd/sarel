package sukarabu.arel

import sukarabu.arel.nodes.{Join, SelectCore, SelectStatement, SqlLiteral}

/**
  */
class SelectManager(table: Table) extends TreeManager {
  val ast = new SelectStatement
  override val ctx: SelectCore = ast.cores.last
  from(table)

  def project(projections: Seq[SqlLiteral[String]]): SelectManager = {
    ctx.projections.appendAll(projections)
    this
  }

  def from(table: Table): SelectManager = {
    ctx.source.left = Some(table)
    this
  }

  def from(table: Join): SelectManager = {
    ctx.source.right.append(table)

    this
  }
}
