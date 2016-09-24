package sukarabu
import sukarabu.arel._

/**
  */
class Main {
  def main(args: Array[String]): Unit = {
    val users = new Table('users)
    val sql: String = users.where(users('name).eq("taro")).toSql
    println(sql)
  }

}
