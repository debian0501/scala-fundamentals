package fundamentals


/**
 */
object App {

  def foo2(x : List[String]): String = x.foldLeft("")((a,b) => a + b)

}
