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

    /**
     * This method divides the given list into three sublists
     * using a random pivot.
     * (less than pivot, equal to pivot, greater than pivot)
     *
     * @param list
     * @return
     */
    def pivot(list: List[Int]): (List[Int], List[Int], List[Int]) = {
      val randomPivot = list(new Random().nextInt(input.length))

      list.foldLeft(List[Int](), List[Int](), List[Int]())( (acc, element) => {
        val (lessThanPivot, equalToPivot, greaterThanPivot) = acc

        element match {
          case x if x < randomPivot => (x :: lessThanPivot, equalToPivot, greaterThanPivot)
          case x if x > randomPivot => (lessThanPivot,      equalToPivot, x :: greaterThanPivot)
          case x @ _                => (lessThanPivot,  x ::equalToPivot, greaterThanPivot)
        }
      })
    }

    input match {

      case Nil => Nil
      case oneElementList @ List(x) => oneElementList
      case head :: tail => {

        val (lessThanPivot, equalToPivot, greaterThanPivot) = pivot(input)

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
   * This algorithm can be further improved by stopping when no swapping has been
   * performed during a bubble call.
   *
   * @param input
   * @return
   */
  def bubbleSort(input: List[Int]): List[Int] = {

    /**
     *
     * For input of ( 5 1 4 2 8 )
     * returns (8, List(1 4 2 5)) -> First pass from the example above.
     *
     * @param remaining
     * @return a tuple with the maxElement in the given list and the rest of the list
     */

    def bubble(remaining: List[Int]): (Int, List[Int]) = {

      remaining match {
        case first :: second :: tail => {

          if (first >= second) {
            val (maxElement, untraversed) = bubble(first :: tail)
            (maxElement, second :: untraversed)
          }
          else {
            val (maxElement, untraversed) = bubble(second :: tail)
            (maxElement, first :: untraversed)
          }
        }
        case maxElement :: Nil => (maxElement, Nil)
      }
    }

    /**
     * For a given unsorted list, accumulates results in resultList
     * by calling bubble each time and adding the maxElement to the
     * resultList with each call.
     *
     * @param unsorted
     * @param resultList
     * @return
     */
    def sort(unsorted: List[Int], resultList: List[Int]): List[Int] = {

      unsorted match {
        case Nil => Nil
        case oneElementList @ List(x) => oneElementList
        case _ :: _ => {

          val (maxElement, tail) = bubble(unsorted)

          tail match {
            case head :: Nil => head :: maxElement :: resultList
            case _ :: _  => sort(tail, maxElement :: resultList)
          }
        }
      }
    }

    sort(input, List[Int]())
  }


  /**
   * Merge sort algorithm(https://en.wikipedia.org/wiki/Merge_sort)
   *
   * Start       : 3--4--2--1--7--5--8--9--0--6
   * Select runs : 3--4  2  1--7  5--8--9  0--6
   * Merge       : 2--3--4  1--5--7--8--9  0--6
   * Merge       : 1--2--3--4--5--7--8--9  0--6
   * Merge       : 0--1--2--3--4--5--6--7--8--9
   *
   * @param input
   * @return
   */
  def mergeSort(input: List[Int]): List[Int] = {

    /**
     * Merges two sorted lists
     *
     * @param list1
     * @param list2
     * @return
     */
    def merge(list1: List[Int], list2: List[Int]): List[Int] = {

      (list1, list2) match {
        case (head :: Nil, Nil) => list1
        case (Nil, head :: Nil) => list2
        case (head1 :: tail1, Nil) => list1
        case (Nil, head1 :: tail1) => list2
        case (head1 :: tail1, head2 :: tail2) => {

          if (head1 < head2) {
            head1 :: merge(tail1, list2)
          } else {
            head2 :: merge(list1, tail2)
          }
        }
      }
    }

    /**
     * Performs merge sort but dividing the input list into n sublists
     * and repeatedly merging them to produce sorted sublists until it
     * has one final sorted list.
     *
     * @param list
     * @return
     */
    def sort(list: List[Int]): List[Int] = {

      val midPoint = if (list.size % 2 == 0)
        list.size / 2
      else
        list.size / 2 + 1

      list match {
        case Nil => Nil
        case head :: Nil => list
        case head :: tail => {
          val (firstPart, secondPart) = list.splitAt(midPoint)

          merge( sort(firstPart), sort(secondPart) )
        }
      }
    }

    sort(input)
  }

  /**
   *
   * Selection sort algorithm (https://en.wikipedia.org/wiki/Selection_sort)
   *
   * 64 25 12 22 11 // this is the initial, starting state of the array
   * 11 64 25 12 22 // sorted sublist = {11}
   * 11 12 64 25 22 // sorted sublist = {11, 12}
   * 11 12 22 64 25 // sorted sublist = {11, 12, 22}
   * 11 12 22 25 64 // sorted sublist = {11, 12, 22, 25}
   * 11 12 22 25 64 // sorted sublist = {11, 12, 22, 25, 64}
   *
   * @param input
   * @return
   */
  def selectionSort(input: List[Int]): List[Int] = {

    /**
     * Returns a tuple with the minimum element and rest of
     * the list.
     *
     * @param currentMin
     * @param remaining
     * @return
     */
    def findMin(currentMin: Int, remaining: List[Int]): (Int, List[Int]) = {

      remaining match {
        case Nil => (currentMin, Nil)
        case head :: tail => {

          if (currentMin > head) {
            val (newMin, unsorted) = findMin(head, tail)
            (newMin, currentMin :: unsorted)
          } else {
            val (newMin, unsorted) = findMin(currentMin, tail)
            (newMin, head :: unsorted)
          }
        }
      }
    }

    def sort(list: List[Int]): List[Int] = {

      list match {
        case Nil => Nil
        case head :: Nil => list
        case head :: tail => {
          val (min, unsorted) = findMin(head, tail)
          min :: sort(unsorted)
        }
      }
    }

    sort(input)
  }


}
