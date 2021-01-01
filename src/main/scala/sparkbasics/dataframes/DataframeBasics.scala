package sparkbasics.dataframes
/*
import org.apache.spark.SparkSession
val spark:SparkSession = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate()
      * 
      */
object DataframeBasics {
  
val columns = Seq("language","users_count")
val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))
//val distData = sc.parallelize(data)
//val df = data.toDF(columns:_*)
//df.show()
}