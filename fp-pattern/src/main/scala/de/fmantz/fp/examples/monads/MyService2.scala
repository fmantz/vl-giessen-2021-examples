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

import scala.util.control.NonFatal

object MyService2 extends MyDummyDB {

  def getCarRent(userId: Int): String = {
    if (CarsRent.contains(userId)) {
      CarsRent(userId)
    } else {
      throw new IllegalArgumentException(s"User $userId not found!")
    }
  }

  def getCheckNo(carNumber: String): String = {
    if (CarsReturned.contains(carNumber)) {
      CarsReturned(carNumber)
    } else {
      throw new IllegalArgumentException(s"Car $carNumber not returned!")
    }
  }

  def getFixingCosts(checkNo: String): Int = {
    if (FixingCosts.contains(checkNo)) {
      FixingCosts(checkNo)
    } else {
      throw new IllegalArgumentException(s"Check $checkNo not finished!")
    }
  }

  //more pain:
  //returns an integer... but not always...
  def getDeposit(userId: Int): Int = {
    val carNo = getCarRent(userId)
    val checkNo = getCheckNo(carNo)
    val fixingCosts = getFixingCosts(checkNo)
    InitialDeposit - fixingCosts
  }

  def main(args: Array[String]): Unit = {
    for (userId <- Seq(42, 100, 200, 300)) {
      try {
        println(s"userId=$userId deposit=${getDeposit(userId)}")
      } catch {
        case NonFatal(ex) => println(ex.getMessage)
      }
    }
  }
}
