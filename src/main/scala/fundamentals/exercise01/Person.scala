package fundamentals.exercise01

class Person(val firstName: String, val lastName: String) {

  def name = firstName + " " + lastName

  // Implement a companion object for Person containing an apply method that accepts
  // a whole name as a single string rather than individual first and last names.

}
