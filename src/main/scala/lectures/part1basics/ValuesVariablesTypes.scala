package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)
  // VALS ARE IMMUTABLE

  val y = 43
  println(y)
  // COMPILER can infer types

  val aString: String = "hello";
  // semicolons optional,
  // but required if two expressions on the same line (bad practice)

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 4324234234234234533L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effects



}
