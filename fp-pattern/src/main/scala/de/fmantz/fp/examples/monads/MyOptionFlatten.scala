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
package de.fmantz.fp.examples.monads

//Anmerkungen zu Monaden
object MyOptionFlatten {

  //Wir haben eine Monade mit (flatMap, unit) implementiert.
  //Eine Funktion flatten ergibt sich dann wie unten definiert.
  //
  //Alternativ haette man die Monade 'MyOption' auch mit
  //(map, flatten, unit) implementieren können.
  //In dem Fall ergibt sich dann flatMap(f) = map(f) ; flatten
  //Dies könnte eine gute Fingerübung sein!
  //
  //Es gibt auch noch weitere Varianten eine Monade zu implementieren,
  //wie über den Kleisi-Operator, siehe hierzu:
  //https://de.wikipedia.org/wiki/Monade_(Informatik)

  def flatten[T, M <: MyOption[T]](myOption: MyOption[M]) : MyOption[T] = {
    myOption.flatMap(id => id)
  }

  def main(args: Array[String]): Unit = {

    val myOption = MyOption.unit(41)
    val addOne: Int => MyOption[Int] = x => MySome(x + 1)

    //Bsp: flatMap ist aequivalent zu map(f) und anschliessend flatten:
    println(flatten[Int, MyOption[Int]](myOption.map(addOne)))
    println(myOption.flatMap(addOne))

  }

}
