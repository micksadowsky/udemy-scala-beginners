package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Johm", 26)
  println(person.age)
  println(person.x)

  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))


}
// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println(1 + 3)

  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")

}
// class parameters are NOT FIELDS
/*
  Novel and a Writer

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author(Writer)
    - authorAge
    - isWrittenBy(author)
    - copy (new year of release) = new instance of Novel
*/

class Writer(firstName: String, surname: String, val year: Int) {
  def fullname(): String = {
    s"$firstName $surname"
  }
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = {
    yearOfRelease - author.year
  }

  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  def copy(newYear: Int): Novel = {
    new Novel(this.name, newYear, this.author)
  }
}


/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
* */

class Counter(val n: Int) {
  def currentCount(): Int = n

  def increment(): Counter = {
    new Counter(n+1)
  }

  def decrement(): Counter = {
    new Counter(n-1)
  }

  def increment(x: Int): Counter = {
    new Counter(n+x)
  }

  def decrement(x: Int): Counter = {
    new Counter(n-x)
  }
}

