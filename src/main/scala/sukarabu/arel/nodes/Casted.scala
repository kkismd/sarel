package sukarabu.arel.nodes

import sukarabu.arel.attributes.Attribute

/**
  */
class Casted[A](val value: A, val attribute: Attribute) extends Node {

}
