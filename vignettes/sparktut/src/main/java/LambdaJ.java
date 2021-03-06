import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;

/**
 * SPARK contains two classes of operations:
 * 1. Transformations
 * 2. Actions
 *
 * Transformations are operations on RDDs that return a new RDD, such as map() and filter(). (an RDD is a resiliant distributed dataset, see RDD.* for more details).
 * Actions are operations that return a result to the driver program or write it to storage, and kick off a computation, such as count() and first().
 * Spark treats transformations and actions very differently, so understanding which type of operation you are performing will be important.
 * If you are ever confused whether a given function is a transformation or an action, you can look at its return type:
 * transformations return RDDs, whereas actions return some other data type.
 *
 * a Lambda is a way of passing logic at runtime into a method.  It is a shorthand way to define functions inline in Scala or Python.
 * When using Spark with these languages you can also define a function separately and then pass its name to Spark for execution on the cluster
 * In general, any Transformation can be a Lambda, and some Actions can also be a Lambda.
 *
 * In Java, functions are specified as objects that implement one of Spark’s function interfaces from the org.apache.spark.api.java.function package.
 * There are a number of different interfaces based on the return type of the function.
 *
 * Standard Usage:
 *
 Function name  |   Method to implement |   Usage

 Function<T, R> |   R call(T)   | Take in one input and return one output, for use with operations like map() and filter().

 Function2<T1, T2, R>   |   R call(T1, T2)  |   Take in two inputs and return one output, for use with operations like aggregate() or fold().

 FlatMapFunction<T, R>  |   Iterable<R> call(T) |   Take in one input and return zero or more outputs, for use with operations like flatMap().
 *
 */
public class LambdaJ {



    public static void main(String[] args){

        //make a connection on localhost to spark
        SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
        JavaSparkContext sc = new JavaSparkContext(conf);

        //load a vcf as text into a RDD
        JavaRDD<String> lines = sc.textFile("src/test/resources/example.vcf");

        //example of creating a filter using an anonymous inner class
        //RDD<String> dataLines =

        System.out.println("Finished");
    }


}
