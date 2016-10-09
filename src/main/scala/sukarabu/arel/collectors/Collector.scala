package sukarabu.arel.collectors

/**
  * Created by cake on 2016/09/25.
  */
trait Collector {
  def value: String
  def << (str: String): Unit
}
