package examples


/**
 *
 * The many uses of foldLeft
 *
 * There are higher order functions which can be used while implementing below methods but
 * we implemented the methods to illustrate the usage of foldLeft.
 *
 */
object FoldLeft {


  /**
   * Gets the sum of all the elements on the list
   *
   * @param input
   * @return
   */
  def sum(input: List[Int]): Int = {
    //we could actually use input.sum
    input.foldLeft(0)((accumulator, element) => accumulator + element)

    //Tnis is possible when parameters are referred to exactly once in the function literal, and in the same order as the parameter list.
    //input.foldLeft(0)(_ + _)
  }

  /**
   * Gets the product of all the elements on the list
   *
   * @param input
   * @return
   */
  def product(input: List[Int]): Int = {
    //we could actually use input.product
    input.foldLeft(1)((accumulator, element) => accumulator * element)
    //input.foldLeft(0)(_ * _)
  }

  /**
   * Count the number of items on the list
   *
   * @param input
   * @return
   */
  def count(input: List[Int]): Int = {
    //we could actually use input.length
    input.foldLeft(0)((accumulator, element) => accumulator + 1)
  }

  /**
   * For average you could do input.sum / input.list but just to show
   * foldLeft usage, we are doing it in this complex way in which we
   * calculate sum and count as we go thru the list.
   *
   * The idea is accumulator is a tuple which has (sumSoFar, countSoFar)
   *
   * @param input
   * @return
   */
  def average(input: List[Int]): Double = input match {
    case head :: tail => {
      val (total, count) = input.foldLeft( (0, 0) )( (acc, element) => (acc._1 + element, acc._2 + 1) )
      total.toDouble / count.toDouble
    }
    case Nil => Double.NaN
  }

  /**
   * Grab the last items on the list
   *
   * @param input
   * @return
   */
  def last(input: List[Int]): Int = {
    //we could actually use input.last
    input.foldLeft(input.head)((acc, element) => element)
  }

  /**
   * Gets the last but one element on the list.
   *
   * Accumulator contains a tuple (next-to-last, last)
   *
   * @param input
   * @return
   */
  def lastButOne(input: List[Int]): Int = {
    input.foldLeft( (input.head, input.head) )( (acc, element) => (acc._2, element))._1
  }

  /**
   * Retruns true if searchElement is present in the inputList
   *
   * @param input
   * @param searchElement
   * @return
   */
  def contains(input: List[Int], searchElement: Int): Boolean = {
    input.foldLeft(false)( (acc, element) => element == searchElement)
  }

  /**
   * Reverses a list
   *
   * @param input
   * @return
   */
  def reverse(input: List[Int]): List[Int] = {
    input.foldLeft(List[Int]())( (acc, element) => element :: acc)
  }

}
