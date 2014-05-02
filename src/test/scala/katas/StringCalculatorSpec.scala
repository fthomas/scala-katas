package katas

import org.scalatest._

import StringCalculator._

class StringCalculatorSpec extends FlatSpec with Matchers {
  "add" should "return 0 for the empty string" in {
    add("") should be(0)
  }
}
