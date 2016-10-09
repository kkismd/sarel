package sukarabu.arel.attributes

import sukarabu.arel.nodes.Node
import sukarabu.arel.{Predications, Table}

/**
  */
class Attribute(val relation: Table, val name: Symbol) extends Node with Predications {

}

