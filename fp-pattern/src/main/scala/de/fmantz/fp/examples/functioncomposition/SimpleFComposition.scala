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

object SimpleFComposition {

  val addOne: Int => Int = x => x + 1
  val divTwo: Int => Int = x => x / 2

  val addOneDivTwoV1: Int => Int = divTwo compose addOne //divTwo ° addOne
  val addOneDivTwoV2: Int => Int = addOne andThen divTwo //addOne ; divTwo

  def main(args: Array[String]): Unit = {
    println("The answer is =" + addOneDivTwoV1(83))
    println("The answer is =" + addOneDivTwoV2(83))
  }

}
