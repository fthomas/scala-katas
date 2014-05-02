package katas

object StringCalculator {
  def add(numbers: String): Int = {
    def splitNumbers(input: String): List[Int] = {
      val marker = "//"
      val lines = input.lines
      val delimiter =
        if (input.startsWith(marker)) lines.next().stripPrefix(marker)
        else ","
      lines.toList.flatMap(_.split(delimiter)).map(_.toInt)
    }

    def throwIfContainsNegatives(list: List[Int]): Unit = {
      val negatives = list.filter(_ < 0)
      if (negatives.nonEmpty) {
        val message = "negatives not allowed: " + negatives.mkString(", ")
        throw new IllegalArgumentException(message)
      }
    }

    val smallIntegers = splitNumbers(numbers).filter(_ <= 1000)
    throwIfContainsNegatives(smallIntegers)
    smallIntegers.sum
  }
}
