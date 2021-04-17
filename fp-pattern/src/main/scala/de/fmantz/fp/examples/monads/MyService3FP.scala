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

//This time using own Option-Implementation
object MyService3FP extends MyDummyDB {

  def getCarsRent(userId: Int): MyOption[String] = {
    CarsRent.get(userId).map(MyOption.unit).getOrElse(MyNone[String]())
  }

  def getCarsReturned(carRent: String): MyOption[String] = {
    CarsReturned.get(carRent).map(MyOption.unit).getOrElse(MyNone[String]())
  }

  def getFixingCost(checkNo: String): MyOption[Int] = {
    FixingCosts.get(checkNo).map(MyOption.unit).getOrElse(MyNone[Int]())
  }

  def getDeposit(userId: Int): MyOption[Int] = {
    for {
      carRent <- getCarsRent(userId)
      checkNo <- getCarsReturned(carRent)
      fixingCost <- getFixingCost(checkNo)
    } yield {
      InitialDeposit - fixingCost
    }
  }

  def main(args: Array[String]): Unit = {
    for (userId <- Seq(42, 100, 200, 300)) {
      getDeposit(userId).map((deposit: Int) => s"userId=$userId deposit=$deposit").foreach(println)
    }
  }

}
