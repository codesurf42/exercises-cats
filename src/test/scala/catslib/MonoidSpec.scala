/*
 * scala-exercises - exercises-cats
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package catslib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class MonoidSpec extends Spec with Checkers {
  def `has a empty operation` = {
    check(
      Test.testSuccess(
        MonoidSection.monoidEmpty _,
        "" :: "abc" :: "" :: HNil
      )
    )
  }

  def `advantages of using monoid operations` = {
    val aMap: Map[String, Int]       = Map("a" → 4, "b" → 2)
    val anotherMap: Map[String, Int] = Map()

    check(
      Test.testSuccess(
        MonoidSection.monoidAdvantage _,
        aMap :: anotherMap :: HNil
      )
    )
  }

  def `accumulating with a monoid on foldMap` = {
    check(
      Test.testSuccess(
        MonoidSection.monoidFoldmap _,
        15 :: "12345" :: HNil
      )
    )
  }

  def `accumulating with a tuple on foldMap` = {
    check(
      Test.testSuccess(
        MonoidSection.tupleMonoid _,
        (15, "12345") :: HNil
      )
    )
  }
}
