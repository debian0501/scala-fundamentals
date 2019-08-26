package fundamentals.exercise06

/*
 * Implement functionn called tupleOp which uses a two 2-dimensional tuple and a function which
 */
object TupleOps {

  /*
   * This function applies a function f on the given vectors a and b
   */
  def tupleOp(a: (Int, Int), b: (Int, Int))(f: ((Int, Int),(Int, Int)) => Int) : Int =
    f(a, b)

  /*
   * Implement a function called scalarProduct which calculates the scalar product of two given vectors
   * The scalar product of (a1, a2) (b1, b2) is defined as (a1 * b1) + (a2 * b)
   */
  val scalarProduct = ??? //TODO implement


  /**
   * use the given functions to calculate the scalar product of two vectors an print the result
   */
  def main(args: Array[String]): Unit = ??? //TODO implement
}
