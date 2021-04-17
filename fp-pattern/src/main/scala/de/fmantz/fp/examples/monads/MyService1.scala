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

object MyService1 extends MyDummyDB {

  //pyramid of doom:
  def getDeposit(userId: Int): Int = {
    if (CarsRent.contains(userId)) {
      val carRent = CarsRent(userId)
      if (CarsReturned.contains(carRent)) {
        val checkNo = CarsReturned(carRent)
        if (FixingCosts.contains(checkNo)) {
          val fixingCosts = FixingCosts(checkNo)
          InitialDeposit - fixingCosts
        } else {
          0
        }
      } else {
        0
      }
    } else {
      0
    }
  }

  def main(args: Array[String]): Unit = {
    for (userId <- Seq(42, 100, 200, 300)) {
      println(s"userId=$userId deposit=${getDeposit(userId)}")
    }
  }

}
