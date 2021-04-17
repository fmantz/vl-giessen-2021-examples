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
package de.fmantz.fp.examples.functioncomposition

object MeanCalc {

  //common way:
  def sum(a: Double, b: Double): Double = a + b
  def div(n: Double, d: Double): Double = n / d

  def mean(a: Double, b: Double): Double = div(sum(a, b), 2)

  //functional way:
  val sumF: (Double, Double) => Double = (x, y) => x + y //define as closure
  val divF: (Double, Double) => Double = div //or to closure

  val div2Partial: Double => Double = divF(_, 2) //partial application
  val sumFTupled: ((Double, Double)) => Double = sumF.tupled

  //function composition:
  val meanFv1 = div2Partial compose sumFTupled //div2Partial ° sumFTupled
  val meanFv2 = sumFTupled andThen div2Partial //sumFTupled ; div2Partial

  def main(args: Array[String]): Unit = {
    println("Test0=" + mean(23, 61))
    println("Test1=" + meanFv1(23, 61))
    println("Test2=" + meanFv2(23, 61))
  }

}
