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

//This time with error messages:
object MyService2FP extends MyDummyDB {

  def getCarRent(userId: Int): Either[String, String] = {
    CarsRent.get(userId).map(carNo => Right(carNo)).getOrElse(Left(s"User $userId not found!"))
  }

  def getCheckNo(carNumber: String): Either[String, String] = {
    CarsReturned.get(carNumber).map(checkNo => Right(checkNo)).getOrElse(Left(s"Car $carNumber not returned!"))
  }

  def getFixingCosts(checkNo: String): Either[String, Int] = {
    FixingCosts.get(checkNo).map(fixingCosts => Right(fixingCosts)).getOrElse(Left(s"Check $checkNo not finished!"))
  }

  def getDeposit(userId: Int): Either[String, Int] = {
    for {
      carRent <- getCarRent(userId)
      checkNo <- getCheckNo(carRent)
      fixingCost <- getFixingCosts(checkNo)
    } yield {
      InitialDeposit - fixingCost
    }
  }

  def main(args: Array[String]): Unit = {
    for (userId <- Seq(42, 100, 200, 300)) {
      getDeposit(userId) match {
        case Right(deposit) => println(s"userId=$userId deposit=$deposit")
        case Left(error) => println(s"Error occured: $error")
      }
    }
  }

}
