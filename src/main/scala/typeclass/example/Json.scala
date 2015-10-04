package typeclass.example

import scala.annotation.implicitNotFound

/**
 * Type class. Converts a given type[T] to JsonValue
 *
 * @tparam T
 */
@implicitNotFound("No member of type class JsonConvertible in scope for ${T}")
trait Json[T] {
  def json(t: T): JsonValue
}

/**
 * Companion object for JsonConvertible. If and only if no other implicit value
 * can be found, the compiler will look in the companion object of the type of the
 * implicit parameter. Hence, as a library designer, putting your default type class
 * implementations in the companion object of your type class trait means that users
 * of your library can easily override these implementations with their own ones,
 * which is exactly what you want.
 *
 */
object Json {

  /**
   * Converts expression to Json representation
   */
  implicit val expressionToJson = new Json[Expression] {

    def json(expression: Expression): JsonValue = {

      expression match {
        case Number(value) => JsonNumber(value)
        case Plus(lhExpression, rhExpression) => JsonObject(
          Map( "op"  -> JsonString("+"),
            "lhs" -> json(lhExpression),
            "rhs" -> json(rhExpression))
        )
        case Minus(lhExpression, rhExpression) => JsonObject(
          Map( "op"  -> JsonString("-"),
            "lhs" -> json(lhExpression),
            "rhs" -> json(rhExpression))
        )
      }

    }

  }
}