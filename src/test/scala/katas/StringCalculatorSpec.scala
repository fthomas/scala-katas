package katas

import org.scalatest._

import StringCalculator._

class StringCalculatorSpec extends FlatSpec with Matchers {
  "add" should "return 0 for the empty string" in {
    add("") should be(0)
  }
  it should "return 1 for the argument \"1\"" in {
    add("1") should be(1)
  }
  it should "return 3 for the argument \"1,2\"" in {
    add("1,2") should be(3)
  }
}
