package katas

object StringCalculator {
  def add(numbers: String): Int =
    if (numbers.isEmpty) 0 else numbers.split(",").map(_.toInt).sum
}
