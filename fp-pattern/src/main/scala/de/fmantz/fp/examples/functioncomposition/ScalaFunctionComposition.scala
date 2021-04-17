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

case class MyNum(x: Int){
  def add(y: Int) : MyNum = MyNum(x + y)
}

object ScalaFunctionComposition {

  val myAdd: (MyNum, Int) => MyNum = (a, y) => MyNum(a.x + y)

  def main(args: Array[String]): Unit = {
    val x1 = MyNum(1).add(2).add(3) //some kind of function composition
    val x2 = (myAdd.tupled andThen myAdd.curried)(MyNum(1), 2)(3)
    println(x1)
    println(x2)
  }

}
