package sukarabu.arel.nodes

import sukarabu.arel.attributes.Attribute

/**
  */
object Nodes {

  def buildQuated[A](other: A, attribute: Attribute): Node = {
    new Casted[A](other, attribute)
  }
}
