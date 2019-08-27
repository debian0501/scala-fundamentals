package de.maibornwolff.scalafundamentals.exercise05


/*
 * Take Shape from exercise04 and make Shape a sealed trait.
 * Then write a singleton object called Draw with an apply method that takes a
 * Shape as an argument and returns a description of it on the console. For example:
 *
 * Draw(Circle(10))
 * // res1: String = A circle of radius 10.0cm
 *
 * Draw(Rectangle(3, 4))
 * // res2: String = A rectangle of width 3.0cm and height 4.0cm
 *
 */
trait Shape {

}

case class Circle(/*TODO*/) extends Shape
case class Rectangle(/*TODO*/) extends Shape
case class Square(/*TODO*/) extends  Shape


object Draw {


}



