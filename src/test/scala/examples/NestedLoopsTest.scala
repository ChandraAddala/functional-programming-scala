package examples

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NestedLoopsTest extends FunSuite {

  test ("insertion sort: input data is not sorted properly") {
    assert(NestedLoops.insertionSort(Nil).isEmpty, "empty list")
    assert(NestedLoops.insertionSort(List(5)) == List(5), "list with only one element")
    assert(NestedLoops.insertionSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9), "random list")
    assert(NestedLoops.insertionSort(List( 1, 2, 3, 4, 5, 6, 7, 8)) == List( 1, 2, 3, 4, 5, 6, 7, 8), "already sorted list")
    assert(NestedLoops.insertionSort(List( 1, 1, 1, 1, 1, 1)) ==List( 1, 1, 1, 1, 1, 1), "list filled with one element")
  }

  test ("quick sort: input data is not sorted properly") {
    assert(NestedLoops.quickSort(Nil).isEmpty, "empty list")
    assert(NestedLoops.quickSort(List(5)) == List(5), "list with only one element")
    assert(NestedLoops.quickSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9), "random list")
    assert(NestedLoops.quickSort(List( 1, 2, 3, 4, 5, 6, 7, 8)) == List( 1, 2, 3, 4, 5, 6, 7, 8), "already sorted list")
    assert(NestedLoops.quickSort(List( 1, 1, 1, 1, 1, 1)) ==List( 1, 1, 1, 1, 1, 1), "list filled with one element")
  }


}
