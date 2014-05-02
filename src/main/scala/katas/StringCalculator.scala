package katas

object StringCalculator {
  def add(numbers: String): Int = {
    val marker = "//"
    val lines = numbers.lines
    val delimiter =
      if (numbers.startsWith(marker)) lines.next().stripPrefix(marker)
      else ","

    lines.flatMap(_.split(delimiter)).map(_.toInt).sum
  }
}
