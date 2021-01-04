package sparkbasics.dataframes

import org.apache.spark.sql.SparkSession

object DataframeBasics {

  val spark: SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .getOrCreate()

  import spark.implicits._

  val columns = Seq("language", "users_count")
  val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))
  val df = data.toDF(columns: _*)
  df.show()
}