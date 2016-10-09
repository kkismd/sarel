package sukarabu.arel

import sukarabu.arel.attributes.Attribute
import sukarabu.arel.nodes._

/**
  */
trait Predications { this: Attribute =>
  def eq(other: String): Equality = {
    val left = new Quoted(other)
    new Equality(this, left)
  }
}
