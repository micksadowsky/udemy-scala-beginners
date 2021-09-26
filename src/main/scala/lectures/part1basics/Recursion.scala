package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int):Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need a factorial of "+ (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }
  println(factorial(10))

  def anotherFactorial(n:Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TALI RECURSION = use recursive call as last expression
    }
    factHelper(n,1)
  }
  println(anotherFactorial(20000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  /*
  1. Concatenate a string n times
  2. IsPrime function, tail recursive
  3. Fibonacci function, tail recursive
  * */

  def stringConcat(aString: String, n: Int): String = {
    @tailrec
    def concatHelper(aString:String, x: Int, accumulator: String):String = {
      if (x <= 0) accumulator
      else concatHelper(aString, x-1, accumulator+aString)
    }
    concatHelper(aString, n, "")
  }

  println(stringConcat("text ", 5))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t-1, n % t != 0 && isStillPrime)
    }
    isPrimeTailRec(n/2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTrailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fiboTrailrec(i + 1, last + nextToLast, last)
    }
    if (n<= 2) 1
    else fiboTrailrec(2, 1, 1)
  }
  println(fibonacci(8))


}
