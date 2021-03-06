package examples

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SortingAlgorithmsTest extends FunSuite {

  test ("insertion sort: input data is not sorted properly") {
    assert(SortingAlgorithms.insertionSort(Nil).isEmpty, "empty list")
    assert(SortingAlgorithms.insertionSort(List(5)) == List(5), "list with only one element")
    assert(SortingAlgorithms.insertionSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9), "random list")
    assert(SortingAlgorithms.insertionSort(List( 1, 2, 3, 4, 5, 6, 7, 8)) == List( 1, 2, 3, 4, 5, 6, 7, 8), "already sorted list")
    assert(SortingAlgorithms.insertionSort(List( 1, 2, 3, 4, 5, 6, 7, 8, 9)) == List( 1, 2, 3, 4, 5, 6, 7, 8, 9), "reverse sorted list")
    assert(SortingAlgorithms.insertionSort(List( 1, 1, 1, 1, 1, 1)) ==List( 1, 1, 1, 1, 1, 1), "list filled with one element")
  }

  test ("quick sort: input data is not sorted properly") {
    assert(SortingAlgorithms.quickSort(Nil).isEmpty, "empty list")
    assert(SortingAlgorithms.quickSort(List(5)) == List(5), "list with only one element")
    assert(SortingAlgorithms.quickSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9), "random list")
    assert(SortingAlgorithms.quickSort(List( 1, 2, 3, 4, 5, 6, 7, 8)) == List( 1, 2, 3, 4, 5, 6, 7, 8), "already sorted list")
    assert(SortingAlgorithms.quickSort(List( 1, 2, 3, 4, 5, 6, 7, 8, 9)) == List( 1, 2, 3, 4, 5, 6, 7, 8, 9), "reverse sorted list")
    assert(SortingAlgorithms.quickSort(List( 1, 1, 1, 1, 1, 1)) ==List( 1, 1, 1, 1, 1, 1), "list filled with one element")
  }

  test ("bubble sort: input data is not sorted properly") {
    assert(SortingAlgorithms.bubbleSort(Nil).isEmpty, "empty list")
    assert(SortingAlgorithms.bubbleSort(List(5)) == List(5), "list with only one element")
    assert(SortingAlgorithms.bubbleSort(List( 5, 1, 4, 2, 8)) == List( 1, 2, 4, 5, 8), "random list - 1")
    assert(SortingAlgorithms.bubbleSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9), "random list - 2")
    assert(SortingAlgorithms.bubbleSort(List( 1, 2, 3, 4, 5, 6, 7, 8, 9)) == List( 1, 2, 3, 4, 5, 6, 7, 8, 9), "already sorted list")
    assert(SortingAlgorithms.bubbleSort(List( 8, 7, 6, 5, 4, 3, 2, 1)) == List( 1, 2, 3, 4, 5, 6, 7, 8), "reverse sorted list")
    assert(SortingAlgorithms.bubbleSort(List( 1, 1, 1, 1, 1, 1)) ==List( 1, 1, 1, 1, 1, 1), "list filled with one element")
  }

  test ("merge sort: input data is not sorted properly") {
    assert(SortingAlgorithms.mergeSort(Nil).isEmpty, "empty list")
    assert(SortingAlgorithms.mergeSort(List(5)) == List(5), "list with only one element")
    assert(SortingAlgorithms.mergeSort(List( 5, 1, 4, 2, 8)) == List( 1, 2, 4, 5, 8), "random list - 1")
    assert(SortingAlgorithms.mergeSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9), "random list - 2")
    assert(SortingAlgorithms.mergeSort(List( 1, 2, 3, 4, 5, 6, 7, 8, 9)) == List( 1, 2, 3, 4, 5, 6, 7, 8, 9), "already sorted list")
    assert(SortingAlgorithms.mergeSort(List( 8, 7, 6, 5, 4, 3, 2, 1)) == List( 1, 2, 3, 4, 5, 6, 7, 8), "reverse sorted list")
    assert(SortingAlgorithms.mergeSort(List( 1, 1, 1, 1, 1, 1)) ==List( 1, 1, 1, 1, 1, 1), "list filled with one element")
  }

  test ("selection sort: input data is not sorted properly") {
    assert(SortingAlgorithms.mergeSort(Nil).isEmpty, "empty list")
    assert(SortingAlgorithms.mergeSort(List(5)) == List(5), "list with only one element")
    assert(SortingAlgorithms.mergeSort(List( 5, 1, 4, 2, 8)) == List( 1, 2, 4, 5, 8), "random list - 1")
    assert(SortingAlgorithms.mergeSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9), "random list - 2")
    assert(SortingAlgorithms.selectionSort(List( 64, 25, 12, 22, 11)) == List(11, 12, 22, 25, 64), "random list - 3")
    assert(SortingAlgorithms.mergeSort(List( 1, 2, 3, 4, 5, 6, 7, 8, 9)) == List( 1, 2, 3, 4, 5, 6, 7, 8, 9), "already sorted list")
    assert(SortingAlgorithms.mergeSort(List( 8, 7, 6, 5, 4, 3, 2, 1)) == List( 1, 2, 3, 4, 5, 6, 7, 8), "reverse sorted list")
    assert(SortingAlgorithms.mergeSort(List( 1, 1, 1, 1, 1, 1)) ==List( 1, 1, 1, 1, 1, 1), "list filled with one element")
  }
}
