package fundamentals.exercise02

/* Turn this class into a case class
 * What happens with our companion object? Is Scala’s case class code generator still working as expected?
 */
class Person(val firstName: String, val lastName: String) {

  def name = firstName + " " + lastName

  object Person {

    def apply(fullName: String): Person = {
      val parts = fullName.split(" ")
      new Person(parts(0), parts(1))
    }
  }

}