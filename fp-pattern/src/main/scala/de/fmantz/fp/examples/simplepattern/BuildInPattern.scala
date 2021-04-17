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

object BuildInPattern {

  //Pattern are everywhere:
  def main(args: Array[String]): Unit = {

    //Print even numbers by power of 2 between [1,10] ordered descendingly
    (1 to 10)
      .filter(_ % 2 == 0)
      .map(x => x * x)
      .reverse
      .foreach(println)

    //Square numbers from [0,9] printed with as tuples (squareNumber, index)
    val arr = Array
      .tabulate(10)(i => i * i)
      .zipWithIndex

    arr.foreach(println)

    val (squareNumbers, indices) = arr.unzip
    squareNumbers.foreach(println) //print only square numbers

    //Check if all square numbers are > 0
    println(squareNumbers.forall(_ > 0)) //false
    println(squareNumbers.exists(_ > 0)) //true

    println("Giessen".distinct.sorted) //Geins
    println(Array(1, 2, 42, 3).max) //42
  }

}
