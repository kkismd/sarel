package sukarabu.arel

import sukarabu.arel.attributes.Attribute
import sukarabu.arel.nodes.{Casted, Equality, Node, Nodes}

/**
  */
trait Predications { this: Attribute =>
  def eq[A](other: A): Equality = {
    new Equality(this, quatedNode(other))
  }

  def quatedNode[A](other: A): Node = {
    Nodes.buildQuated(other, this)
  }
}
