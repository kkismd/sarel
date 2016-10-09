package sukarabu.arel.collectors

/**
  * Created by cake on 2016/09/25.
  */
class SqlString extends Collector {
  private val buff = new StringBuilder
  private var bindIndex = 1

  def value: String = {
    buff.result()
  }

  def << (str: String): Unit = {
    buff.append(str)
  }
}
