package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x) // + 247013495593200
    println("by value: " + x) // + 247013495593200
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x) // + System.nanoTime()
    println("by name: " + x) // + System.nanoTime()
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(34, infinite())
}
