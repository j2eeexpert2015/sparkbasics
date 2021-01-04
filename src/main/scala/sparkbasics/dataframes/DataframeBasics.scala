package sparkbasics.dataframes

import org.apache.spark.sql.SparkSession

/**
 Introducing DataFrames
1.In Spark, DataFrames are the distributed collections of data, organized into rows and columns
2.Each column in a DataFrame has a name and an associated type.
3.DataFrames can be created from various sources, such as structured data files ,Hive tables,external databases, or the existing RDDs.
4.DataFrames allow the processing of huge amounts of data.
5.DataFrames use the Catalyst Optimizer to determine the optimal way to execute your code
 **/

//Create case class for later use
case class Person(Name: String , Age: Int)

object DataframeBasics {

  def main(args: Array[String]) {
     val spark: SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("DataframeBasics")
    .getOrCreate()

    /**
    Create Dataframes manually - Using toDF() on List or Seq collection
    The toDF() method can be called on a sequence object to create a DataFrame.
    toDF() can be accessed after importing Spark implicits.
     **/
  import spark.implicits._

  val columns = Seq("language", "users_count")
  val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))
  val df = data.toDF(columns: _*)
  df.show()

    //Using toDF() with Scala Case Classes
    val personDF = Seq(Person("James", 24), Person("John",42)).toDF
    personDF.show()

    //Using createDataFrame() from Spark Session
    var df2 = spark.createDataFrame(data).toDF(columns:_*)
    df2.show()

  }
}