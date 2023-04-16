package cl.uchile.dcc
package test

import gwent.model.cards.effects.uniteffect.NullEffectUnit
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}

class CardTest extends munit.FunSuite {
  var Siegue1: SiegeUnit = _
  var Siegue2: SiegeUnit = _
  var Siegue3: SiegeUnit = _
  var Distance1: DistanceUnit = _
  var Distance2: DistanceUnit = _
  var Distance3: DistanceUnit = _
  var Melee1: MeleeUnit = _
  var Melee2: MeleeUnit = _
  var Melee3: MeleeUnit = _

  override def beforeEach(context: BeforeEach): Unit = {

    Siegue1 = new SiegeUnit("siegue1", 5,NullEffectUnit)
    Siegue2 = new SiegeUnit("siegue2", 5,NullEffectUnit)
    Siegue3 = new SiegeUnit("siegue2", 5,NullEffectUnit)

    Distance1 = new DistanceUnit("Distance1", 3,NullEffectUnit)
    Distance2 = new DistanceUnit("Distance2", 6,NullEffectUnit)
    Distance3 = new DistanceUnit("Distance2", 6,NullEffectUnit)

    Melee1 = new MeleeUnit("Melee1", 8,NullEffectUnit)
    Melee2 = new MeleeUnit("Melee2", 5,NullEffectUnit)
    Melee3 = new MeleeUnit("Melee2", 5,NullEffectUnit)

  }

  test("equal SiegueUnit addresses") {
    assert(Siegue1.equals(Siegue1))
  }


  test("equal SiegueUnit values") {
    assertEquals(Siegue2.equals(Siegue3), true)
  }

  test("not equal SiegueUnit values") {
    assertEquals(Siegue1.equals(Siegue3), false)
  }

  test("equal DistanceUnit addresses") {
    assertEquals(Distance1.equals(Distance1), true)
  }

  test("equal DistanceUnit values") {
    assertEquals(Distance2.equals(Distance3), true)
  }

  test("not equal DistanceUnit values") {
    assertEquals(Distance1.equals(Distance3), false)
  }

  test("equal MeleeUnit addresses") {
    assertEquals(Melee1.equals(Melee1), true)
  }

  test("equal MeleeUnit values") {
    assertEquals(Melee2.equals(Melee3), true)
  }

  test("not equal MeleeUnit values") {
    assertEquals(Melee1.equals(Melee3), false)
  }

}
