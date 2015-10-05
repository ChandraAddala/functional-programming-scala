package examples.typeclass

/**
 * Represents an ADT for an mathematical expression. (Limited functionality)
 *
 */
sealed trait Expression
case class Number (value: Int) extends Expression
case class Plus (lhs: Expression, rhs: Expression) extends Expression
case class Minus (lhs: Expression, rhs: Expression) extends Expression

object ExpressionEvaluator {

  def value (expression: Expression) : Int = {

    expression match {
      case Number(value) => value
      case Plus(lhExpression, rhExpression) => value(lhExpression) + value(rhExpression)
      case Minus(lhExpression, rhExpression) => value(lhExpression) - value(rhExpression)
    }
  }

}