package examples

import scala.util.Random

/**
 * Some examples which probably involves writing nested
 * loops with mutable state in imperative style of programming.
 *
 * Illustrating functional way of writing such code.
 * Both programs probably have the same asymptotic
 * complexity
 *
 */
object NestedLoops {

  /**
   * Insertion sort algorithm(https://en.wikipedia.org/wiki/Insertion_sort)
   * typically has nested loops with mutable state in imperative style of program
   *
   * Steps of an insertion sort:
   * 3 7 4 9 5 2 6 1
   * 3 7 4 9 5 2 6 1
   * 3 7 4 9 5 2 6 1
   * 3 4 7 9 5 2 6 1
   * 3 4 7 9 5 2 6 1
   * 3 4 5 7 9 2 6 1
   * 2 3 4 5 7 9 6 1
   * 2 3 4 5 6 7 9 1
   * 1 2 3 4 5 6 7 9
   *
   * @param input
   * @return
   */
  def insertionSort(input: List[Int]): List[Int] = {

    input.foldLeft(List[Int]())( (acc, element) => {

      val (firstHalf, secondHalf) = acc.span(_ < element)

      //inserting the element at the right place
      firstHalf ::: element :: secondHalf
    })
  }

  /**
   *
   * Quick sort algorithm (https://en.wikipedia.org/wiki/Quicksort)
   *
   * 1. Pick an element, called a pivot, from the array.
   * 2. all elements with values less than the pivot come before the pivot;
   *    all elements with values greater than the pivot come after it (equal
   *    values can go either way)
   * 3. Recursively apply the above steps to the sub-array of elements
   *    with smaller values and separately to the sub-array of elements
   *    with greater values.
   *
   * The implementation below is not tail recursive. So there is a possibility
   * of StackOverflowError.
   *
   * @param input
   * @return
   */
  def quickSort(input: List[Int]): List[Int] = {

    input match {

      case Nil => Nil
      case oneElementList @ List(x) => oneElementList
      case head :: tail => {

        //step 1
        val pivot = input(new Random().nextInt(input.length))

        val (firstHalf, greaterThanPivot) = input.partition(_ <= pivot)
        val (lessThanPivot, equalToPivot) = firstHalf.partition(_ < pivot)

        //step 2 & 3
        quickSort(lessThanPivot) :::
          equalToPivot           :::
          quickSort(greaterThanPivot)

      }
    }

  }




}
