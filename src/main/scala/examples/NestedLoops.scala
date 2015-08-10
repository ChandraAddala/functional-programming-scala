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


  /**
   * Bubble sort algorithm(https://en.wikipedia.org/wiki/Bubble_sort)
   *
   * First Pass:
   * ( 5 1 4 2 8 ) \to ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
   * ( 1 5 4 2 8 ) \to ( 1 4 5 2 8 ), Swap since 5 > 4
   * ( 1 4 5 2 8 ) \to ( 1 4 2 5 8 ), Swap since 5 > 2
   * ( 1 4 2 5 8 ) \to ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
   *
   * Second Pass:
   * ( 1 4 2 5 8 ) \to ( 1 4 2 5 8 )
   * ( 1 4 2 5 8 ) \to ( 1 2 4 5 8 ), Swap since 4 > 2
   * ( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
   * ( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
   *
   * Now, the array is already sorted, but the algorithm does not know if it is completed.
   * The algorithm needs one whole pass without any swap to know it is sorted.
   *
   * Third Pass:
   * ( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
   * ( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
   * ( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
   * ( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
   *
   * @param input
   * @return
   */
  def bubbleSort(input: List[Int]): List[Int] = {

    def bubbleUp(input: List[Int]): List[Int] = {

      val (outputList, lastElement) = input.tail.foldLeft( (List[Int](), input.head) )( (acc, element) => {
        val (resultList, prevElement) = acc

        if (element > prevElement) {
          (prevElement :: resultList, element)
        } else {
          (element :: resultList, prevElement)
        }

      })

      (lastElement :: outputList).reverse
    }

    input match {
      case head :: tail => {
        val outputList = bubbleUp(input)

        if (input == outputList)
          outputList
        else
          bubbleSort(outputList)
      }
      case _ => input
    }


  }

}
