package sukarabu.arel

import sukarabu.arel.attributes.Attribute
import sukarabu.arel.nodes.{Equality, Node, SelectStatement, SqlLiteral}

/**
  */
class Table(val name: Symbol) {
  def apply(name: Symbol): Attribute = {
    new Attribute(this, name)
  }

  def from = new SelectManager(this)

  def where(condition: Equality): TreeManager = {
    from.where(condition)
  }

  def project(things: String*): TreeManager = {
    val x = things.map(SqlLiteral(_))
    from.project(x)
  }
}

object Table {
  val engine = new fake_record.Base
}
