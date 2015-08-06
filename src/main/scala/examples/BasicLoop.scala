package examples

import scala.annotation.tailrec


/**
 *
 * Basic program which computes the sum of list of integers.
 * The program does not use a loop inorder to avoid any
 * mutable state. It uses recursion instead.
 *
 */
object BasicLoop {

  /**
   * Returns sum of list of integers.
   *
   * @param input
   * @return
   */
  def sum(input: List[Int]): Int = {

    /**
     * Uses tail recursion to loop through the list of integers
     *
     * @param acc
     * @param remainingInput
     * @return
     */
    @tailrec
    def loop(acc: Int, remainingInput: List[Int]): Int = {

      remainingInput match {
        case Nil      => acc
        case x :: xs  => loop(acc + x, xs)
      }
    }

    loop(0, input)
  }


  /**
   * Sum using another higher order function(foldLeft)
   *
   * @param input
   * @return
   */
  def sumUsingFoldLeft(input: List[Int]): Int = {
    input.foldLeft(0)((x, y) => x + y)
  }

  /**
   * Sum using another higher order function(sum)
   *
   * @param input
   * @return
   */
  def sumUsingSum(input: List[Int]): Int = {
    input.sum
  }

}
