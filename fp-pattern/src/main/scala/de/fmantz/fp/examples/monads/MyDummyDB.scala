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

abstract class MyDummyDB {

  val InitialDeposit = 1000

  //userid -> car rent
  val CarsRent = Map(
    100 -> "F:AA:1000",
    200 -> "F:AA:2000",
    300 -> "F:AA:3000"
  )
  //car -> checkId
  val CarsReturned = Map(
    "F:AA:1000" -> "check1",
    "F:AA:2000" -> "check42"
  )
  //checkId -> cost
  val FixingCosts = Map(
    "check42" -> 100
  )

}
