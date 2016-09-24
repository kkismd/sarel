package sukarabu.arel

import sukarabu.arel.attributes.Attribute
import sukarabu.arel.nodes.Node

/**
  */
class Table(name: Symbol) {
  def apply(name: Symbol): Attribute = {
    new Attribute(this, name)
  }

  def from = new SelectManager(this)

  def where(condition: Node): TreeManager = {
    from.where(condition)
  }
}
