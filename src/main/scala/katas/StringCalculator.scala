package katas

import java.util.regex.Pattern

// http://osherove.com/tdd-kata-1/

object StringCalculator {
  def add(numbers: String): Int = {
    def stripSquareBrackets(str: String): String =
      str.stripPrefix("[").stripSuffix("]")

    def delimitersAsRegex(raw: String): String = {
      val delimiters = """\[[^\[\]]+\]+|.+""".r.findAllIn(raw)
      delimiters
        .map(stripSquareBrackets)
        .map(Pattern.quote)
        .mkString("(", "|", ")")
    }

    def splitNumbers(input: String): List[Int] = {
      val marker = "//"
      val lines = input.lines
      val delimiters =
        if (input.startsWith(marker)) {
          val delimitersLine = lines.next().stripPrefix(marker)
          delimitersAsRegex(delimitersLine)
        } else ","

      lines.flatMap(_.split(delimiters)).map(_.toInt).toList
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
