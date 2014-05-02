package katas

import java.util.regex.Pattern

object StringCalculator {
  def add(numbers: String): Int = {
    def splitNumbers(input: String): List[Int] = {
      val marker = "//"
      val lines = input.lines
      val delimiter =
        if (input.startsWith(marker)) {
          val rawDelimiter = lines.next()
            .stripPrefix(marker)
            .stripPrefix("[")
            .stripSuffix("]")
          Pattern.quote(rawDelimiter)
        } else ","
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
