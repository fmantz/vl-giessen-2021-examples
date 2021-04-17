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

//basic monad example:
sealed trait MyOption[M] {
  //flatMap or 'bind':
  def flatMap[T](f: M => MyOption[T]): MyOption[T] //needed to define Monad
  //can be derived (there are more):
  def map[T](f: M => T): MyOption[T] = flatMap (f.andThen(MyOption.unit))
  def foreach[T](f: M => T): Unit = map(f)
}
//constructors could be used
case object MyOption{
  //unit or 'return'
  def unit[M](x: M): MyOption[M] = {
    if(x != null) MySome(x) else MyNone[M]() //needed to define Monad
  }
}
case class MyNone[M]() extends MyOption[M] {
  override def flatMap[T](f: M => MyOption[T]): MyOption[T] = MyNone[T]()
}
case class MySome[M](value:M) extends MyOption[M] {
  override def flatMap[T](f: M => MyOption[T]): MyOption[T] = f(value)
}


