package examples

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NestedLoopsTest extends FunSuite {

  test ("insertion sort: input data is not sorted properly") {
    assert(NestedLoops.insertionSort(Nil).isEmpty)
    assert(NestedLoops.insertionSort(List(5)) == List(5))
    assert(NestedLoops.insertionSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9))
  }

}
