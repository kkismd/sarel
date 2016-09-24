package sukarabu.arel

import sukarabu.arel.nodes.{SelectCore, SelectStatement}

/**
  */
class SelectManager(val table: Table) extends TreeManager {
  val ast = new SelectStatement
  override val ctx: SelectCore = ast.cores.last
}
