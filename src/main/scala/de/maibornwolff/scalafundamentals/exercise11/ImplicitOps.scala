package de.maibornwolff.scalafundamentals.exercise11

object ImplicitOps {

  //Define an Ordering that orders Ints from lowest to highest by absolute value.
  //If everything is correct the main method should run without an exception.
  implicit val ordering = ???

  def main(args: Array[String]): Unit = {

    assert(List(-4, -1, 0, 2, 3).sorted == List(0, -1, 2, 3, -4))
    assert(List(-4, -3, -2, -1).sorted == List(-1, -2, -3, -4))
  }

}
