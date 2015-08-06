package examples

import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FoldLeftTest extends FunSuite {

  test("should return sum of all elements") {
    assert(FoldLeft.sum(Nil) == 0)
    assert(FoldLeft.sum(List(1, 2, 3, 4, 5)) == 15)
  }

  test("should return product of all elements") {
    assert(FoldLeft.product(Nil) == 1)
    assert(FoldLeft.product(List(1, 2, 3, 4, 5)) == 120)
  }

  test("should return number of elements in the list") {
    assert(FoldLeft.count(Nil) == 0)
    assert(FoldLeft.count(List(9)) == 1)
    assert(FoldLeft.count(List(1, 2, 3, 4, 5)) == 5)
  }

  test("should return average of elements in the list") {
    assert(FoldLeft.average(Nil).isNaN)
    assert(FoldLeft.average(List(9)) == 9)
    assert(FoldLeft.average(List(1, 2, 3, 4, 6)) == 3.2)
  }

  test("should return last element in the list") {
    intercept[NoSuchElementException] {
      FoldLeft.last(Nil)
    }
    assert(FoldLeft.last(List(9)) == 9)
    assert(FoldLeft.last(List(1, 2, 3, 4, 5)) == 5)
  }

  test("should return last but one element in the list") {
    intercept[NoSuchElementException] {
      FoldLeft.lastButOne(Nil)
      FoldLeft.lastButOne(List(1))
    }
    assert(FoldLeft.lastButOne(List(2, 9)) == 2)
    assert(FoldLeft.lastButOne(List(1, 2, 3, 4, 5)) == 4)
  }

  test("should return reverse of a list") {
    assert(FoldLeft.reverse(Nil).isEmpty)
    assert(FoldLeft.reverse(List(2, 9)) == List(9, 2))
    assert(FoldLeft.reverse(List(1, 2, 3, 4, 5)) == List(5, 4, 3, 2, 1))
  }
}

