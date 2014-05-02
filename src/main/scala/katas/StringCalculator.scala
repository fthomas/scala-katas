package katas

import java.util.regex.Pattern

object StringCalculator {
  def add(numbers: String): Int = {
    def parseDelimiters(raw: String): String = {
      val delimiters = """\[[^\[\]]+\]+|.+""".r.findAllIn(raw)
      delimiters
        .map(_.stripPrefix("[").stripSuffix("]"))
        .map(Pattern.quote)
        .mkString("(", "|", ")")
    }

    def splitNumbers(input: String): List[Int] = {
      val marker = "//"
      val lines = input.lines
      val delimiters =
        if (input.startsWith(marker)) {
          val delimitersLine = lines.next().stripPrefix(marker)
          parseDelimiters(delimitersLine)
        } else ","

      lines.toList.flatMap(_.split(delimiters)).map(_.toInt)
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
