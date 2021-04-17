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

object MyService1FP extends MyDummyDB {

  def getDeposit(userId: Int): Option[Int] = {
    for {
      carRent <- CarsRent.get(userId)
      checkNo <- CarsReturned.get(carRent)
      fixingCost <- FixingCosts.get(checkNo)
    } yield {
      InitialDeposit - fixingCost
    }
  }

  def main(args: Array[String]): Unit = {
    for (userId <- Seq(42, 100, 200, 300)) {
      getDeposit(userId).map(deposit => s"userId=$userId deposit=$deposit").foreach(println)
    }
  }

}
