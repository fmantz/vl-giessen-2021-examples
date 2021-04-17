//scalastyle:off
/*
 * Simple examples explaining FP concepts
 * Copyright (C) 2021 Florian Mantz
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
//scalastyle:on
package de.fmantz.fp.examples.simplepattern

import scala.annotation.tailrec

object FoldExamples {

  //Disclaimer: we ignore negative numbers here

  //simple approach:
  def sum(n: Int): Int = {
    var result = 0
    for (i <- 1 to n) {
      result += i
    }
    result
  }

  def product(n: Int): Int = {
    var result = 1
    for (i <- 1 to n) {
      result *= i
    }
    result
  }

  //on our way to FP:
  def iterPattern(n: Int, init: Int, f: (Int, Int) => Int): Int = {
    var result = init
    for (i <- 1 to n) {
      result = f(result, i)
    }
    result
  }

  def sumV2(n: Int) = iterPattern(n, init = 0, _ + _)

  def productV2(n: Int) = iterPattern(n, init = 1, _ * _)

  //FP style:
  @tailrec
  def foldLeft(list: List[Int], init: Int, f: (Int, Int) => Int): Int = {
    list match {
      case Nil => init
      case head::tail => foldLeft(tail, f(head, init), f)
    }
  }

  def sumF(n: Int) = foldLeft((1 to n).toList, 0, _ + _)

  def productF(n: Int) = foldLeft((1 to n).toList, 1, _ * _)

  //FP style with standard libs:
  def sumByStdLib(n: Int) = (1 to n).foldLeft(0)(_ + _)

  def productByStdLib(n: Int) = (1 to n).foldLeft(1)(_ * _)

  def prefixStrings(s: String) : List[String]  = {
    s.foldLeft(List(""))((lastResult, nextChar) => (lastResult.head ++ nextChar.toString) :: lastResult)
  }

  def main(args: Array[String]): Unit = {
    //"classic" implementation:
    println(sum(10))
    println(product(10))

    //intermediate style
    println(sumV2(10))
    println(productV2(10))

    //"fp" implementation:
    println(sumF(10))
    println(productF(10))

    //"buildIn" implementation
    println(sumByStdLib(10))
    println(productByStdLib(10))

    prefixStrings("Giessen").foreach(println)
    /*
        Giessen
        Giesse
        Giess
        Gies
        Gie
        Gi
        G
    */
  }

}
