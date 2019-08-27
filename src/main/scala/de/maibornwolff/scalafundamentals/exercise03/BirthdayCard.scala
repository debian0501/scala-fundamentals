package de.maibornwolff.scalafundamentals.exercise03


case class Person(firstName: String, lastName: String, age: Int = 0)

object BirthdayCard {

  /* Implement this method which says something according to the age of the person
   * age == 18: Happy birthday <firstName> you made it, you're finally of age.
   * age == 0: All the best for the birth
   * else Happy Birthday <firstName>
   */
  def happyBirthday(person : Person) : String = ???

}

