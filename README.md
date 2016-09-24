# SArel

```scala
val users = new Table('users)
val sql = users.where(users('name) eq "taro").toSql
println(sql)
```
