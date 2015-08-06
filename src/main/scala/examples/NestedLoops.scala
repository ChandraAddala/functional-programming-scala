package examples

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

}
