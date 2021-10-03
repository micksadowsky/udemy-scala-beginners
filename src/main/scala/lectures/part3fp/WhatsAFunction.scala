package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: oop

  val doubler = new MyFuntcion[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A,B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  // 1. a function, which takes 2 strings and concatenates them
  // 2. MyList transform the MyPredicate and MyTransforment into function types
  // 3. define a fuction, which takes an int and returns another functio,
  // which takes an in int and return an int
  //  - what's the type of this function
  //  - how to do it

  val concatenator: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(s1: String, s2: String): String = s1 + s2
  }
  println(concatenator("Hello ", "Scala"))

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Int => Int = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function



}
trait MyFuntcion[A, B] {
  def apply(element: A): B = ???
}
