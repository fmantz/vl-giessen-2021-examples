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

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class MyOptionTests extends AnyFlatSpec with Matchers {

  //also see https://devth.com/2015/monad-laws-in-scala

  //note: please use Option instead of null in your code
  val f: String => MyOption[String] = a => if(a != null) MySome(a.reverse) else MyNone[String]()
  val g: String => MyOption[String] = a => if(a != null) MySome(a.toLowerCase) else MyNone[String]()

  "MyOption" should "satisfy monad law 'left identity'" in {
    val input = "Giessen 2021"
    val lhs: MyOption[String] = MyOption.unit(input).flatMap(f)
    val rhs: MyOption[String] = f(input)
    lhs shouldBe rhs
  }

  it should "satisfy monad law 'right identity'" in {
    val monad = MyOption.unit("Giessen 2021")
    val lhs = monad.flatMap(MyOption.unit)
    val rhs = monad
    lhs shouldBe rhs
  }

  it should "satisfy monad law 'associativity'" in {
    val monad = MyOption.unit("Giessen 2021")
    val lhs = monad.flatMap(f).flatMap(g)
    val rhs = monad.flatMap(x => f(x).flatMap(g))
    lhs shouldBe rhs
  }

  it should "satisfy monad law 'left identiy' for empty input" in {
    val input : String = null
    val lhs: MyOption[String] = MyOption.unit(input).flatMap(f)
    val rhs: MyOption[String] = f(input)
    lhs shouldBe rhs
  }

  it should "satisfy monad law 'right identity' for empty input" in {
    val monad = MyOption.unit[String](null)
    val lhs = monad.flatMap(MyOption.unit)
    val rhs = monad
    lhs shouldBe rhs
  }

  it should "satisfy monad law 'associativity' for empty input" in {
    val monad = MyOption.unit[String](null)
    val lhs = monad.flatMap(f).flatMap(g)
    val rhs = monad.flatMap(x => f(x).flatMap(g))
    lhs shouldBe rhs
  }

}
