package sukarabu.arel.visitors

import sukarabu.arel.Table
import sukarabu.arel.collectors.Collector
import sukarabu.arel.nodes._
import sukarabu.arel.attributes.Attribute

/**
  * Created by cake on 2016/09/25.
  */
class ToSql extends Visitor {
  private val SPACE = " "
  private val COMMA = ", "
  private val WHERE = " WHERE "
  private val AND = " AND "

  def visit(node: SelectStatement, collector: Collector): Collector = {
    node.cores.foreach { selectCore =>
      visit(selectCore, collector)
    }
    collector
  }

  def visit(selectCore: SelectCore, collector: Collector): Collector = {
    collector << "SELECT"

    if (selectCore.projections.nonEmpty) {
      collector << SPACE
      val len = selectCore.projections.length - 1
      selectCore.projections.zipWithIndex.foreach { case (x, i) =>
        visit(x, collector)
        if (len != i) collector << COMMA
      }
    }
    if (selectCore.source.nonEmpty) {
      collector << " FROM "
      visit(selectCore.source, collector)
    }
    if (selectCore.wheres.nonEmpty) {
      collector << WHERE
      val len = selectCore.wheres.length - 1
      selectCore.wheres.zipWithIndex.foreach { case (x, i) =>
          visit(x, collector)
          if (len != i) collector << AND
      }
    }

    collector
  }

  def visit(equality: Equality, collector: Collector): Collector = {
    visit(equality.left, collector)

    if (equality.right == Quoted.Null) {
      collector << " IS NULL"
    }
    else {
      collector << " = "
      visit(equality.right, collector)
    }
    collector
  }

  def visit(quoted: Quoted, collector: Collector): Collector = {
    collector << s"'${quoted.value}'"
    collector
  }

  def visit(attribute: Attribute, collector: Collector): Collector = {
    val joinName = attribute.relation.name
    val columnName = attribute.name
    collector << s"${quoteTableName(joinName)}.${quoteColumnName(columnName)}"
    collector
  }

  def visit(node: SqlLiteral[String], collector: Collector): Collector = {
    collector <<  node.string
    collector
  }

  def visit(node: JoinSource, collector: Collector): Collector = {
    node.left.foreach { table =>
      visit(table, collector)
    }
    if (node.right.nonEmpty) {

    }
    collector
  }

  def visit(table: Table, collector: Collector): Collector = {
    collector << quoteTableName(table.name)
    collector
  }

  def quoteTableName(name: String): String = {
    s""""$name""""
  }

  def quoteColumnName(name: String): String = {
    s""""$name""""
  }
}
