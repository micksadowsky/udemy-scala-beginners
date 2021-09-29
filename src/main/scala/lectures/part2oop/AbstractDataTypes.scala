package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract members
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBLooded

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"
    def eat: Unit = "nomnomnom"
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}!")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract clases
  // 1 - traits do not have construcor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = "behaviour", abstract class = "thing"

}
