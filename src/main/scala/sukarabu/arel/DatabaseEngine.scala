package sukarabu.arel

import sukarabu.arel.fake_record.Connection

/**
  * Created by cake on 2016/09/25.
  */
trait DatabaseEngine {
  val connection: Connection
}
