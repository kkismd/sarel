package sukarabu.arel.nodes

/**
  */
class Quoted(val value: String) {

}

object Quoted {
  object Null extends Quoted("NULL")
}