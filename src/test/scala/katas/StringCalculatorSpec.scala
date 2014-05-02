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
  it should "handle more than two numbers" in {
    add("1,2,3") should be(6)
    add("4,5,6,7,0") should be(22)
  }
  it should "allow new lines as delimiters" in {
    add("1\n2,3") should be(6)
  }
  it should "allow the delimiter to be specified" in {
    add("//;\n1;2") should be(3)
  }
  it should "throw an exception for negative numbers" in {
    val exception = intercept[IllegalArgumentException](add("-1,1,-2"))
    exception.getMessage should be("negatives not allowed: -1, -2")
  }
}
