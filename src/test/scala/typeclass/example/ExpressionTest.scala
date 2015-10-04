package typeclass.example

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExpressionTest extends FunSuite {

  test("test evaluate") {

    val exp: Expression = Plus( Number(5), Minus( Number(2), Number(1) ) )
    val evalResult = ExpressionEvaluator.value(exp)

    assert(evalResult == 6, "Wrong evaluation result")
  }
  
}
