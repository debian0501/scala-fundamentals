---
title: Scala de.maibornwolff.fundamentals
separator: <!--s-->
verticalSeparator: <!--v-->
theme: league
revealOptions:
    transition: 'fade'
---
<!--s-->
# Scala fundamentals
Stefan López Romero 2019

<!--s-->

# What is Scala
<!--v-->

## History
* The design of Scala started in 2001 by [Martin Odersky](https://de.wikipedia.org/wiki/Martin_Odersky).
* Martin Odersky formerly worked on Java Generics and javac.
* Version 2.13.0 has recently been released.
* Scala 3 aka [Dotty](https://dotty.epfl.ch/) is currently under construction and will be release in 2020.

Notes: 
*  École polytechnique fédérale de Lausanne
<!--v-->

## Features
* Java like syntax
* Supports OOP and FP from the ground up.
* Strongly typed with unified type system.
* Many features from FP languages 
* Language interoperability with Java.
* Runs on JVM

Notes: 
<!--s-->


# Getting started
<!--v-->
## Setup Scala and tools

* Install scala (2.13.0) from https://www.scala-lang.org/download/
* Install IntelliJ IDEA Scala plugin
* Clone https://github.com/debian0501/scala-de.maibornwolff.fundamentals 

<!--v-->
## Try Scala REPL

REPL = Read Evaluate Print Loop
```console
stefanl@localhost ~> scala
Welcome to Scala 2.13.0 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_131).
Type in expressions for evaluation. Or try :help.

scala> "Hello World!"
res0: String = Hello World!

scala>
```

Notes: 
* Each input is evaluated immediately
* Result can be reused.
* Paste Mode with :paste
* Multiline Expressions
* :paste + file
* :type Type of an expression

<!--v-->

## Try IntelliJ Scala Console


 Command               | Short cut         
-----------------------|:-----------------:
evaluate code          | Cmd + Enter       
send code to console   | Ctrl + Shift + X  

Notes: 
* Im Grunde REPL nur in InteliJ integriert

<!--v-->

## Creating your First Application
![HelloWorld](./assets/hello_world.png)

Notes: 
* New Scala Object
* main: def main(args: Array[String]): Unit = {

<!--v-->
## Useful Documentation

* API Doc: https://www.scala-lang.org/api/2.13.0/index.html
* Tour of Scala: https://docs.scala-lang.org/tour/tour-of-scala.html
* Scala Cheetsheet: https://docs.scala-lang.org/cheatsheets/index.html
* Book - Essential Scala: https://underscore.io/books/essential-scala/

<!--s-->

# Scala type system

<!--v-->
## Unified type system
* In Scala there are no primitive types. 
* Every type is an object
* Operators such as + and - are also methods

> Any Scala expression written **a.b(c)** can also be written **a b c**.

Note:
```scala
123.toShort // this is how we define a `Short` in Scala
// res5: Short = 123
(1).+(2) // same as 1 + 2
"the quick brown fox" split " "
```
* An expression is a combination of one or more values, constants, variables, operators and functions that the programming language interprets and computes to produce another value.
* A statement is the smallest standalone element of an imperative programming language that expresses some action to be carried out.

<!--v-->

## Exercises

```scala

// 1. Rewrite in operator-style
"in scala every type is an object".split(" ")


// 2. Rewrite in method call style
43 - 3 + 2


```
<!--v-->

## Basic Types

* Scala’s _Int, Double, Boolean ..._ corresponding to Java's primitive types.
* These types are called value types.
* Strings are exactly Java’s strings, and are written the same way.
* These types are called reference types.

<!--v-->
## Nulls

```console
scala> null
res4: Null = null
```
* Null is the same as Java. 
* Scala’s _null_ also has its own type: _Null_.
* It is not possible to assign _null_ to a value type
* _null_ s are considered very bad practice in Scala

Note:
* Therefore option is used

<!--v-->
## Unit
```console
scala> :type ()
Unit
```
* Equivalent of Java’s _void_
* The value of Unit is written as _()_

<!--v-->

## Objects

```scala
Object NameOfObject = {
  //some declarations or expressions
}
```
* An object is a class that has exactly one instance.
* Useful for creating a class with utility methods. 
* It is created lazily when it is referenced.

Note:
* Is similar to a final Java class with static methods

<!--v-->

## Methods
```scala
Object Test {
  def name(parameter: type, ...): resultType =
    bodyExpression
  // or
  def name: resultType =
    bodyExpression
}
```
* result type is optional but it is good practice to define it as it serves as documentation.
* _return_ is implicit. There is no need to write _return_ like you would in Java.

Note:
* _name_ is the name of the method.
* the optional _parameters_ are the names given to parameters to the method.
* the _types_ are the types of the method parameters
* the optional _resultType_ is the type of the result of the method.
* the _bodyExpression_ is an expression that calling the method evaluates to.
```scala
object Test3 {
  def sayHello : String = "Hello"

  def hello(name: String) : String =
    "Hello " + name
}
```
<!--v-->
## Fields
```scala
Object Test {
  val name: type = valueExpression
  // or
  var name: type = valueExpression  
}
```
* _type_ declaration is optional. 
* _val_ defines an immutable field, meaning we cannot change the value bound to the name 
* _var_ defines an mutable field, allowing us to change the bound value.
* Always prefer _val_ to _var_.

Note: 
```console
scala> val v = 1
v: Int = 1

scala> v = 2
         ^
       error: reassignment to val
```

```console
scala> var v = 1
v: Int = 1

scala> v = 2
mutated v

scala> v
res0: Int = 2
```
<!--v-->
## Methods versus fields
```scala
object Test {
  val field = {
    println("evaluate field")
    42
  }
  def method = {
    println("evaluate method")
    42
  }
}
```
Note:
* Why fields when you can have methods without parameters too
* The object is defined, but nothing is executed yet (lazy loading)
* Test.field:  body expression of a field is run only once
* Test.method: body of a method is evaluated every time we call the method
<!--v-->


## Exercises
* Define an object called _Math_ with a method _square_ which squares its input parameter.
* Add a method called _cube_ that cubes its input calling _square_ as part of its result calculation.

Note: 
```scala
object Math {
  
  def square(num: Double) : Double = num * num
  def cube(num: Double) : Double = square(num) * num
}
```
<!--v-->
## if Expression
```scala
if(condition)
  trueExpression
else
  falseExpression
```

* Scala’s if is an **expression**. 
* It has a type and returns a value.

Note: 
* :type if(true) "true"
* :type if(false) "true"

<!--v-->
## Blocks

```scala
{
  val hello = "Hello"
  val world = "World"
  println(hello)
  println(world)
  hello + world
}
```

* sequence of expressions or declarations
* used to produce side effects or to name intermediate results
* returns the value of the last expression

Note:
* a block is also a expression
<!--v-->

## Type hierachy
![Type Hierachy](./assets/type_hierachy.png)

* Nothing is the type of throw expressions
* Null is the type of the value null

<!--s-->
# Objects and Classes

<!--v-->

## Classes
```scala
class Person {
  val firstName = "Donald"
  val lastName = "Duck"
  def name = firstName + " " + lastName
}
```
* Scala classes are all subclasses of _java.lang.Object_
* The default printing behaviour of Person comes from the _toString_ method defined in _java.lang.Object_.
 
Note: 
* val p = new Person
* p.firstName
* p.name

<!--v-->

## Constructors
```scala
class Person(first: String, last: String) {
  val firstName = first
  val lastName = last
  def name = firstName + " " + lastName
}
```
Or
```scala
class Person(val firstName: String, val lastName: String) {
  def name = firstName + " " + lastName
}
```
Note: 
* val immutable (only getter)
* var mutable (getter and setter)
class Person(var firstName: String, var lastName: String) {
  def name = firstName + " " + lastName
}
* p.firstName = "daisy"
* Optional: java beans @BeanProperty
* Visibility: class Person(private val firstName: String, val lastName: String)

<!--v-->
## Default and Keyword Parameters 

This is particularly useful when creating methods and constructors with a large number of parameters.

```scala
class Person(val firstName: String = "Donald", 
             val lastName:  String = "Duck") {

  def name = firstName + " " + lastName
  
}
```

```console
scala> val p = new Person(lastName = "Trump")
p: Person = Person@4d5665bb

```

<!--v-->
## Companion Objects
```scala
class Timestamp(val seconds: Long)

object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp =
    new Timestamp(hours*60*60 + minutes*60 + seconds)
}
```
```console
scala> Timestamp(1, 1, 1).seconds
res4: Long = 3661
```
* A companion object has the same name as its associated class
* Is like a Java static method.
* _apply_ gives us the ability to make the method look like a constructor.

Note:
* Scala programmers almost always prefer to implement additional constructors as apply methods on an object with the same name as the class
* Scala has two namespaces: a space of type names and a space of value names
```console
scala> :type Timestamp
Timestamp.type

scala> :type new Timestamp(1)
Timestamp`
```
<!--v-->
## Exercises
* See workspace exercise01
* Tip: you can split a String into an Array of components as follows:

```scala
val parts = "John Doe".split(" ")
// parts: Array[String] = Array(John, Doe)
parts(0)
// res3: String = John
```
<!--v-->
## Case Classes
```scala
case class Person(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}
```
* Case classes are ideal for creating lightweight data-holding classes eg. TOs.
* Scala automatically generates a class and companion object
<!--v-->

## Features of a case class
1. A field for each constructor argument
1. A default toString method 
1. Sensible equals, and hashCode methods
1. A copy method 
1. Extends the Product and Serializable traits.

Note: 
* Scala’s == operator is different from Java’s—it delegates to equals. eq stands for object identity
* The copy method let us copy an object while changing the values of one or more fields:
```scala
case class Person(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}
val p = new Person("Stefan", "López")
val pNew= p.copy(lastName="Cimander")
```
<!--v-->
## Features of a case class companion object
```scala
val p = Person("Donald", "Duck")
```
1. An apply method with the same arguments as the class constructor
1. Code to implement an extractor pattern for use in pattern matching

Note:
* There are also case objects if a class has no constructor arguments
* Better toString and extends the Product and Serializable traits

<!--v-->
## Exercises

* See workspace exercise02
<!--v-->

## Pattern Matching

```scala
object Greeter {
  
  def sayHello(person: Person) : String = 
      person match {
        case Person("Donald", "Duck") => "hewow"
        case Person("Alois", "Hingerl") => "Servus"
        case Person("Antje", "Wörmsen") => "Goedendag"
        case Person(firstName, lastName) => "Hallo"
      } 
}
```

* Pattern matching is like an extended if expression
* Pattern matching is itself an expression 

<!--v-->
## Pattern Syntax

```scala
Person(pat0, pat1)
```
The following patterns we could use for pat0 or pat1:

1. A name, which matches any value at that position and binds it to the given name
1. An (_), which matches any value and ignores it.
1. A literal, which successfully matches only the value the literal respresents
1. Another case class using the same constructor style syntax

<!--v-->
## Exercises
* See workspace exercise03
<!--s-->

# Traits
<!--v-->

## What is a Trait

* Traits are very much like Java 8’s interfaces with default methods.
* For not Java 8 users: Traits can be considered like a cross between interfaces and abstract classes

<!--v-->
## An Example of Traits
```scala
import java.util.Date

trait Visitor {
  def id: String      // Unique id assigned to each user
  def createdAt: Date // Date this user first visited the site

  // How long has this visitor been around?
  def age: Long = new Date().getTime - createdAt.getTime
}

case class Anonymous(
  id: String,
  createdAt: Date = new Date()
) extends Visitor

case class User(
  id: String,
  email: String,
  createdAt: Date = new Date()
) extends Visitor
```
Notes:

* we defined the trait Visitor
* Anonymous and User are subtypes of the Visitor trait by using the extends keyword.
* The Visitor trait expresses an interface that any subtype must implement
* Any sub-type of Visitor also automatically has a method age as defined in Visitor.
* The methods defined in the trait are derived to the subtypes

<!--v-->
## Traits Compared to Classes

* A trait cannot have a constructor
* Traits can define abstract methods that have names and type signatures but no implementation

> Scala sees `def` as a more general version of `val`. It is good practice to never define vals in a trait, but rather to use def

<!--v-->
## Exercises
* See workspace exercise04
<!--v-->

## Sealed Traits
```scala
sealed trait Visitor { /* ... */ }
final case class User(/* ... */) extends Visitor
final case class Anonymous(/* ... */) extends Visitor
```

* All subtypes must be defined in the same file
* `final` for disallow all extensions
* The compiler will warn us if a pattern matching expression is missing a case

<!--v-->
## Exercises
* See workspace exercise05
<!--v-->

## Mixins
A trait is called mixin when it is mixed with a class
```scala
trait A {
    def message : String
    def whoAmI = "I am trait A"
}
trait B extends A {
  def uppercaseMessage : String = message.toUpperCase
  override def whoAmI = "I am trait B"

}
trait C extends A {
  def reverseMessage : String = message.reverse
  override def whoAmI = "I am trait C"
}
class D extends A with B with C {
    override val message = "Hello"
}
```

Note: 
* Mixins can be thought as a dynamic additions of methods into an object
* In case of conflicting methods the rightmost mixin is used
* Mixins, however, aren't inheritance – it's actually more similar to dynamically 
adding a set of methods into an object. Whereas inheritance says "This thing is a kind of another thing", mixins say, 
"This object has some traits of this other thing

<!--s-->

# Functions

<!--v-->

## Generics
```scala
sealed trait Return 
final case class Success[T](value: T) extends Return
final case class Failure(message: String) extends Return

object Div {
  def safeDiv(divident : Int, divisor: Int) : Return =
      if (divisor == 0) Failure("divide by 0") 
      else Success(divident / divisor) 
      //if we omit the type parameter, scala will infer its value
}
```
<!--v-->

## Working with functions
```scala
sealed trait Return[+T] {
  def map[B] (f: (T) => B) : Return[B] =
    this match {
      case Success(v) => Success(f(v))
      case Failure(m) => Failure(m)
    }
}
final case class Success[T](value: T) extends Return[T]
final case class Failure(message: String) extends Return[Nothing]
```
```scala
Success(1).map(x => x +1)
```
Note: 
* Covariance Nothing is subtype of T
* Return becomes a generic trait
* Nothing as placeholder

<!--v-->
## Function literals
```scala
val sayHello = () => "Hello"
val add1 = (x: Int) => (x + 1) 
val add = (x: Int, y:Int) => x + y
```
* Return type is normally inferred 

<!--v-->

## Placeholder syntax
```scala
Success(1).map(_ + 1)           // == Success(1).map(x => x +1) 
Success(-1).map(math.abs(_))    // == (-1).map(x => math.abs(x)) 
Success(1).map(math.min(5, _))  // == Success(1).map(x => math.min(5, 1))   
_ + _                           // == `(a, b) => a + b`
_(foo)                          // == `(a) => a(foo)`
// and so on...
```
Placeholder syntax should only be used for very small functions.
<!--v-->

## Using methods as functions
```scala
val divFun = Div.safeDiv _
```
If Scala can infer that we need a function, we can even drop the underscore and simply write the method name

```scala
object Div {
  def divBy2(x: Int) : Int = x / 2
}
```

```console
scala> Success(10).map(divBy2)
res48: Return[Int] = Success(5)
```
<!--v-->
## Multiple Parameter Lists
Methods in Scala can have multiple parameter lists


```scala
def foo[A](retVal: A, value: A, f: (A) => Boolean) : A =
  if (f(value)) retVal else value
```
```console
scala> foo("bar", "foo", (x:String) => x == "foo")
res8: String = bar
```
vs
```scala
def foo[A](retVal: A, value: A)( f: (A) => Boolean) : A =
  if (f(value)) retVal else value
```
```console
scala> foo("bar", "foo"){x => x == "foo"}
res2: String = bar
```

Note:
* Scala’s type inference algorithm cannot use a type inferred for one parameter for another parameter
* looks nicer with inline functions
* assist with type inference
<!--v-->

## Tuples
Scala includes tuple types with up to 22 elements
```console
scala> val tuple = ("hi", 1, true)
tuple: (String, Int, Boolean) = (hi,1,true)

scala> tuple._1
res10: String = hi

scala> tuple._2
res11: Int = 1

scala> tuple._3
res12: Boolean = true

```
<!--v-->
## Working with tuples

Tuples as function arguments:
```scala
def tupleAdd(a: (Int, Int), b: (Int, Int)) : (Int, Int) =
    (a._1 + b._1, a._2 + b._2)
```
Pattern matching with tuples:
```scala
def returnDuck(names: (String, String)) : String =
    names match {
      case duck @ (_, "Duck") => s"${duck._1} ${duck._2}"
      case _ => "not found"
    }
```
<!--v-->
## Exercises
* See workspace exercise06

<!--s-->
# Collections

<!--v-->
## Sequences

```console
scala> val sequence = Seq(1, 2, 3)
sequence: Seq[Int] = List(1, 2, 3)
```
* collection of items with a defined and stable order
* Scalas collections are immutable per default
* Type `Seq[Int]` is implemented by a `List`.
* Seq would be Java's List, and Scala's List would be Java's LinkedList

<!--v-->
## Accessing elements

```console
scala> val sequence = Seq(1, 2, 3)
sequence: Seq[Int] = List(1, 2, 3)

scala> sequence.apply(1)
res1: Int = 2

scala> sequence(1)
res2: Int = 2

scala> sequence.head
res3: Int = 1

scala> sequence.tail
res4: Seq[Int] = List(2, 3)
```

Note: 
* IndexOutOfBoundsException if there is no element with this index
* NoSuchElement if no head or tail
* For safely get the head without risking an exception: sequence.headOption

<!--v-->
## Searching for elements

```console
scala> sequence.find(_ == 2)
res8: Option[Int] = Some(2)

scala> sequence.filter(_ > 1)
res9: Seq[Int] = List(2, 3)
```
* find returns the first element which matches the predicate
* filter returns all the matching elements in the sequence
<!--v-->

## Appending/prepending elements

```console
scala> val seq = Seq(1,2,3) 
seq: Seq[Int] = List(1, 2, 3)

scala> seq.:+(4) //append
res19: Seq[Int] = List(1, 2, 3, 4)

scala> seq :+ 4 //idiomatic append
res20: Seq[Int] = List(1, 2, 3, 4)

scala> seq.+:(0) //prepend
res21: Seq[Int] = List(0, 1, 2, 3)

scala> 0 +: seq /idiomatic prepend
res22: Seq[Int] = List(0, 1, 2, 3)

scala> seq ++ Seq(4, 5, 6)
res23: Seq[Int] = List(1, 2, 3, 4, 5, 6)
```

Note:
* Scala’s general syntax rule: Any method ending with a : character becomes right associative when written as an infix operator
<!--v-->

## Lists
* The default implementation of Seq is a List
* Some Libraries using List instead of the more generic Seq type

```console
scala> Nil //empty List
res24: scala.collection.immutable.Nil.type = List()

scala> val list = 1 :: 2 :: 3 :: Nil
list: List[Int] = List(1, 2, 3)

scala> List(1,2,3)
res25: List[Int] = List(1, 2, 3)

scala> List(1,2,3) ::: List(4,5,6) // List concat
res30: List[Int] = List(1, 2, 3, 4, 5, 6)

scala> List(1,2,3) ++ List(4,5,6) // Seq concat
res31: List[Int] = List(1, 2, 3, 4, 5, 6)
```

<!--v-->
## Exercises
* See workspace exercise07
<!--v-->

## For Comprehensions

```scala
for {
  x <- Seq(1, 2, 3)
} yield x * 2
// res1: Seq[Int] = List(2, 4, 6)
```

* The expression containing the <- is called generator.
* a generator has a pattern on the left hand side and a generator expression on the right.
* each element is bind to the pattern and then the yield expression is called. 
* result is a sequence of the same type as the original generator.

<!--v-->
## For Comprehensions in detail (1)
```scala
for {
  x <- List(1,2)
  y <- List(3,4)
  z <- List(5,6)
} yield (x,y,z)
// List((1,3,5), (1,3,6), (1,4,5), (1,4,6), (2,3,5), (2,3,6), (2,4,5), (2,4,6))
```
same as 
```scala
   List(1,2).flatMap(x 
=> List(3,4).flatMap(y 
=> List(5,6).map(z 
=> (x, y, z))))
```
<!--v-->
## For Comprehensions in detail (2)

```scala
for {
  x <- List(1,2)
  y <- List(3,4)
} println(x + y) // without yield for side effects
```
* For comprehensions are very different to for loops in Java 
* For comprehensions can be used in any class that implements map and flatMap

<!--v-->
## Exercises
* See workspace exercise08
<!--v-->

## Options
`Option` is a generic sealed trait with two subtypes— `Some` and `None`

```scala
List("A", "B", "C").find(_ == "B")
//res5: Option[String] = Some(B)

List("A", "B", "C").find(_ == "Z")
//res6: Option[String] = None
```
<!--v-->
## Extracting values from Options
```scala
List("A", "B", "C").find(_ == "B").getOrElse("Not Found")
//res7: String = B
```
```scala
List("A", "B", "C").find(_ == "B") match {
  case Some(str) => s"Found $str"
  case None => "Not Found"
}
//res8: String = Found B
```
```scala
List("A", "B", "C").find(_ == "B").
  map(str => s"Found $str").getOrElse("Not Found")
//res11: String = Found B
```
<!--v-->
## Options in for comprehensions

```scala
def sum(optionA: Option[Int], optionB: Option[Int]) =
  for {
    a <- optionA
    b <- optionB
  } yield a + b
```
```scala
def sum(optionA: Option[Int], optionB: Option[Int]) =
  optionA.flatMap(a => optionB.map(b => a + b))
```
```scala
sum(Some(123), Some(456))
//res2: Option[Int] = Some(579)

sum(Some(123), None)
//res1: Option[Int] = None
```
<!--v-->
## Exercises
* See workspace exercise09
<!--v-->

## Maps
```scala
val map = Map("a" -> 1, "b" -> 2, "c" -> 3)
//map: scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2, c -> 3)
```
* The Map constructor accepts an arbitrary number of `Tuple2` 
* `->` is a function that generates a `Tuple2` 
Note: 
* Type is Map[String,Int]

<!--v-->
## Accessing values
```scala
val map = Map("a" -> 1, "b" -> 2, "c" -> 3)
map("a")
//res3: Int = 1

map("z")
//java.util.NoSuchElementException: key not found: z

map.get("a")
//res5: Option[Int] = Some(1)

map.get("z")
//res6: Option[Int] = None
```
<!--v-->

## Adding and removing elements
```scala
val map = Map("a" -> 1, "b" -> 2, "c" -> 3)

val newMap = map.+("d" -> 4) 
// newMap: scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2, c -> 3, d -> 4)

val newMap2 = map.-("a") 
// newMap2: scala.collection.immutable.Map[String,Int] = Map(b -> 2, c -> 3)

val newMap3 = map + ("d" -> 4)
//res8: scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2, c -> 3, d -> 4)

val newMap4 = map - "a"
//newMap4: scala.collection.immutable.Map[String,Int] = Map(b -> 2, c -> 3)
```

<!--v-->
## Exercises
* See workspace exercise10
<!--v-->

## Ranges
A Range represents a sequence of integers from some starting value to less than the end value with a non-zero step
```scala
1 until 10
// res0: scala.collection.immutable.Range = Range 1 until 10

10 until 1 by -1
//res1: scala.collection.immutable.Range = Range 10 until 1 by -1

for(i <- 0 until 10) println(s"The current number is $i")
//The current number is 0
//The current number is 1
//The current number is 2
//...
```
<!--s-->
# Implicits

<!--v-->
## Ordering as example

```scala
import scala.math.Ordering

val ascOrdering = Ordering.fromLessThan[Int](_ < _)
val descOrdering = Ordering.fromLessThan[Int](_ > _)

List(3, 4, 2).sorted(ascOrdering)
// res1: List[Int] = List(2, 3, 4)

List(3, 4, 2).sorted(descOrdering)
// res3: List[Int] = List(4, 3, 2)
```
To construct an Ordering we can use the convenience method `fromLessThan`

<!--v-->

## Implicit Values
```scala
import scala.math.Ordering

implicit val ordering = Ordering.fromLessThan[Int](_ < _)

List(7, 10, 1).sorted
// res4: List[Int] = List(1, 7, 10)

```
* implicit marked parameter in the method declaration
```scala
override def sorted[B >: A](implicit ord : scala.Ordering[B]) : C
```
* implicit value of the same type as the parameter
* only one such implicit value available.

Note:
* The term B >: A expresses (a lower type bound) that the type parameter B or the abstract type B refer to a supertype of type A
* The compiler will signal an error if there is any ambiguity in which implicit value should be used 
<!--v-->

## Declaring Implicit Values
* An implicit value must be declared within a surrounding object, class, or trait.

```scala
object Implicits {
  implicit val one = ...
  implicit var two = ...
  implicit object three = ...
  implicit def four = ...
}
```
* We can tag any `val`, `var`, `object` or zero-argument `def` with the implicit keyword


<!--v-->

## Implicit scope and priority
Where does the compiler search for implicit values?

1. Local scope (identifiers declared or imported from elsewhere)
1. Companion objects of types involved

Note: 
* Ordering has already a implicit defined for Int (see: https://www.scala-lang.org/api/current/scala/math/Ordering$.html#Int)
* Complete rules are rather complex The practical implication is that the local scope takes precedence over instances found in companion objects


<!--v-->
## Exercises
* See workspace exercise11
<!--v-->

## Implicit Classes

```scala

object StringImplicits {

    implicit class AdditionalStringMethods(str: String) { 
 
      def toCamelCase = {
        str.toLowerCase.split("\\s").
          foldLeft("")((acc, elem) => 
            s"$acc${elem.substring(0,1).toUpperCase}${elem.substring(1)}")
      }
    
    }
}
```
```scala
"This is like extension methods in Kotlin".toCamelCase
//res5: String = ThisIsLikeExtensionMethodsInKotlin
```
Note:
* The Scala compiler uses implicit classes to fix type errors in our code
* The rules for implicit classes are the same as for implicit values
<!--v-->
## Implicit Conversions
We can tag any single-argument method with the implicit keyword to allow the compiler to implicitly use the method to perform automated conversions from one type to another.
```scala
class B {
  def bar = "foo bar"
}

class A

implicit def aToB(in: A): B = new B()

new A().bar
```
Note:
* undisciplined use of implicit conversions can cause as problems
* Better use implicit classes and implicit values/parameters over implicit conversions


<!--s-->
# Conclusion

<!--v-->

## What's missing
* [Packages and imports](https://docs.scala-lang.org/tour/packages-and-imports.html)
* [Nested Methods](https://docs.scala-lang.org/tour/nested-functions.html)
* [Variances](https://docs.scala-lang.org/tour/variances.html) 
* [Type bounds](https://docs.scala-lang.org/tour/upper-type-bounds.html)
* [Package Objects](https://docs.scala-lang.org/tour/package-objects.html)

<!--v-->
## Additional Resources
* [The red book](https://www.manning.com/books/functional-programming-in-scala)
* [Functional Programming Principles in Scala](https://de.coursera.org/learn/progfun1)
* [Rock the JVM! Advanced Scala](https://www.udemy.com/advanced-scala/)
* [Scala with cats](https://underscore.io/books/scala-with-cats/)

<!--v-->

## Thanks