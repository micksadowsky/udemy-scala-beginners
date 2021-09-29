package lectures.part2oop

import playground.{Cindarella => Princess, PrinceCharming} // ._ for all
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Princess // playground.Cindarella = fully qualified name

  // packages are in hierarchy
  // marching folder structure.

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming
  val date = new Date()
  // 1. use FQ names
  val sqlDate = new java.sql.Date(2018, 5, 4)
  // 2. use aliasing
  val sqlDate2 = new SqlDate(2018, 5, 4)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
