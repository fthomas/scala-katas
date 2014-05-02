package katas

object StringCalculator {
  def add(numbers: String): Int = {
    val marker = "//"
    val lines = numbers.lines
    val delimiter =
      if (numbers.startsWith(marker)) lines.next().stripPrefix(marker)
      else ","

    val ints = lines.flatMap(_.split(delimiter)).map(_.toInt).toList
    val negatives = ints.filter(_ < 0)

    if (negatives.nonEmpty)
      throw new IllegalArgumentException("negatives not allowed: " + negatives.mkString(", "))
    else
      ints.sum
  }
}
