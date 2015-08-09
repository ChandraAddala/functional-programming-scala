package examples

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BasicLoopTest extends FunSuite {

  test("Empty List should return sum as zero") {
    val inputList: List[Int] = Nil
    assert(BasicLoop.sum(inputList) == 0)
    assert(BasicLoop.sumUsingFoldLeft(inputList) == 0)
    assert(BasicLoop.sumUsingSum(inputList) == 0)
  }

  test("summation should be correct") {
    val inputList: List[Int] = List(1, 2, 3, 4, 5)
    assert(BasicLoop.sum(inputList) == 15)
    assert(BasicLoop.sumUsingFoldLeft(inputList) == 15)
    assert(BasicLoop.sumUsingSum(inputList) == 15)
  }

  test("factorial should be correct") {
    assert(BasicLoop.factorial(0) == 1)
    assert(BasicLoop.factorial(1) == 1)
    assert(BasicLoop.factorial(5) == 120)
  }

}