package sukarabu.arel.nodes

/**
  */
class Binary[A](val left: Option[A], val right: Option[A]) extends Node {

}

class Join(left: Option[Node], right: Option[Node]) extends Binary(left, right) {

}