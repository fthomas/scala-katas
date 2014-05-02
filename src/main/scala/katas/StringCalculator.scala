package katas

object StringCalculator {
  def add(numbers: String): Int = {
    if (numbers.isEmpty) 0
    else {
      val lines = numbers.lines.toList
      val (numberLines, delimiter) =
        if (lines(0).startsWith("//")) (lines.drop(1), lines(0).stripPrefix("//"))
        else (lines, ",")
      numberLines.flatMap(_.split(delimiter)).map(_.toInt).sum
    }
  }
}
