package sukarabu
import sukarabu.arel._
import sukarabu.arel.nodes.SqlLiteral

/**
  */
object Main {
  def main(args: Array[String]): Unit = {
    val users = new Table("users")
    val sql: String = users.project("*").where(users("name").eq("taro")).toSql()
    println("Start!")
    println(sql)
    println("End.")
  }
}
