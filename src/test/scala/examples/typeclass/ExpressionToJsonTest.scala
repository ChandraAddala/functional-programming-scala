package examples.typeclass

import org.json4s.jackson.JsonMethods._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExpressionToJsonTest extends FunSuite {

  test("expression should be converted to json format without throwing exceptions") {
    val exp: Expression = Plus( Number(5), Minus( Number(2), Number(1) ) )

    val expInJson = JsonWriter.write(exp)
    println(expInJson)

    //Should not throw exception
    parse(expInJson)
  }
}
