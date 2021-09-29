package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }


  // anonymous class
  val funnyAnimal: Animal = new {
    override def eat: Unit = println("ahahhahaha")
  }
/*
  equivalent with

  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahhahaha")
  }
  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
*/
class Person(name: String) {
  def sayHi: Unit = println(s"Hi, my name is $name, how can I help you?")
}

val jim = new Person("Jim") {
  override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
}

  println(funnyAnimal.getClass)

}
