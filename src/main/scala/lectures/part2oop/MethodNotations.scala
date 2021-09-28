package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 20) {
//    val this.age: Int = age

    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie."

    def +(string: String): Person = new Person((s"${this.name} ($string)"), this.favouriteMovie)
    def unary_+ : Person = new Person((this.name), this.favouriteMovie, this.age + 1)
    def learns(what: String): String = s"${this.name} learns $what"
    def learnsScala: String = learns("Scala")
    def apply(n: Int): String = s"${this.name} watched ${this.favouriteMovie} $n times."
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Flight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka actors hav ! ?

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  //  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  /*
  1. Overload the + operator
      mary + "the rockstar" => new person "Mary (the rockstar)"
  2. Add an age to the Person class
      Add a unary + operator => new person with the age + 1
      +mary => mary with the age incremented
  3. Add a "learns" method in the Person class => "Mary learns Scala"
  4. Add a learnScala method, calls learns method with "Scala". Use it in postfix notation.
  5. Overload the apply method
      mary.appply(2) => "Mary watched Inception 2 times"
  * */

  println((mary + "the rockstar").name)
  println(mary.age)
  println((+mary).age)
  println(mary learns "Python")
  println(mary learnsScala)
  println(mary(2))
}
