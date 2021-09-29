package exercises

abstract class MyList[+A] {
  /*
  * head = 1st element of the list
  * tail = remainder of the list
  * isEmpty = is this list empty
  * add(int) => new list with this element added
  * toString = a string representation of the list
  */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

//  def map[B](transformer: MyTransformer[A, B]): MyList[B]
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
//  def filter(predicate: MyPredicate[A]): MyList[A]
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

//  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
//  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
//  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else "" + h + " " + t.printElements
  }

//  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
//    new Cons(transformer.transform(h), t.map(transformer))
//  }
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
//  def filter(predicate: MyPredicate[A]): MyList[A] = {
//    if (predicate.test(h)) new Cons(h, t.filter(predicate))
//    else t.filter(predicate)
//  }
}
// 1. Generic trait MyPredicate[-T]
//    a method test(T) => Boolean that tests whether T passes a condition
// 2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
//   Transform A to B
// 3. MyList;
//    - map(transformer) => MyList
//    - filter(predicate) => MyList
//    - flatMap(transformer from A to MyList[B]) => MyList[B]
//
// class EvenPredicate extends MyPredicate[Int] = whether that Int is even or not
// class StringToIntTransformer extends MyTransformer[String, Int] = turn string to an int
//
// [1,2,3].map(n * 2) = [2,4,6]
// [1,2,3,4].filter(n % 2) = [2,4]
// [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
//

trait MyPredicate[-T] {
  def test(t: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(a: A): B
}





object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.toString)

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val lisstOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfIntegers.toString)
  println(lisstOfStrings.toString)
}