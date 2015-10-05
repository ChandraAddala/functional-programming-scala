package examples.typeclass

import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class JsonWriterTest extends FunSuite {

  test ("json gets serialized properly") {
    val testJson = JsonObject(Map("name" -> JsonString("John"), "isMarried" -> JsonBoolean(true) ))

    //Should not throw exception
    println(parse(JsonWriter.write(testJson)))
  }

}
