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

import org.scalatest._
import flatspec._
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class FoldExamplesTests extends AnyFlatSpec with Matchers {

  "all sum implementations" should "return the same value" in {
    for(i <- 0 until 100){
      val simpleSum = FoldExamples.sum(i)
      FoldExamples.sumV2(i) shouldBe simpleSum
      FoldExamples.sumF(i) shouldBe simpleSum
      FoldExamples.sumByStdLib(i) shouldBe simpleSum
    }
  }

  "all product implementations" should "return the same value" in {
    for(i <- 0 until 100){
      val simpleProduct = FoldExamples.product(i)
      FoldExamples.productV2(i) shouldBe simpleProduct
      FoldExamples.productF(i) shouldBe simpleProduct
      FoldExamples.productByStdLib(i) shouldBe simpleProduct
    }
  }
}
