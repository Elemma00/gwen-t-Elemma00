package cl.uchile.dcc
package test

import gwent.model.cards.effects.uniteffect.NullEffectUnit
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}

import cl.uchile.dcc.gwent.exceptions.InvalidStrengthValue
import cl.uchile.dcc.gwent.model.cards.weathercards.{ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable}

class CardTest extends munit.FunSuite {
  var Siegue1: SiegeUnit = _
  var Siegue2: SiegeUnit = _
  var Siegue3: SiegeUnit = _
  var Siegue4: SiegeUnit = _
  var Distance1: DistanceUnit = _
  var Distance2: DistanceUnit = _
  var Distance3: DistanceUnit = _
  var Distance4: DistanceUnit = _
  var Melee1: MeleeUnit = _
  var Melee2: MeleeUnit = _
  var Melee3: MeleeUnit = _
  var Melee4: MeleeUnit = _

  override def beforeEach(context: BeforeEach): Unit = {

    Siegue1 = new SiegeUnit("siegue1", 5,NullEffectUnit)
    Siegue2 = new SiegeUnit("siegue2", 5,NullEffectUnit)
    Siegue3 = new SiegeUnit("siegue2", 5,NullEffectUnit)
    Siegue4 = new SiegeUnit("siegue1", 3,NullEffectUnit)

    Distance1 = new DistanceUnit("Distance1", 3,NullEffectUnit)
    Distance2 = new DistanceUnit("Distance2", 6,NullEffectUnit)
    Distance3 = new DistanceUnit("Distance2", 6,NullEffectUnit)
    Distance4 = new DistanceUnit("Distance1", 6,NullEffectUnit)

    Melee1 = new MeleeUnit("Melee1", 8,NullEffectUnit)
    Melee2 = new MeleeUnit("Melee2", 5,NullEffectUnit)
    Melee3 = new MeleeUnit("Melee2", 5,NullEffectUnit)
    Melee4 = new MeleeUnit("Melee1", 2,NullEffectUnit)


  }

  test("equal SiegueUnit addresses") {
    assert(Siegue1.equals(Siegue1))
  }

  test("not equal values "){
    assertEquals(Melee1.equals(Melee4), false)
    assertEquals(Distance1.equals(Distance4), false)
    assertEquals(Siegue1.equals(Siegue4), false)
  }

  test("equal SiegueUnit values") {
    assertEquals(Siegue2.equals(Siegue3), true)
  }

  test("not equal SiegueUnit values") {
    assertEquals(Siegue1.equals(Siegue3), false)
  }

  test("playing a SiegueUnit without effects"){
    Siegue1.play()
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

  test("playing a DistanceUnit without effects") {
    Distance1.play()
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

  test("playing a MeleeUnit without effects") {
    Melee1.play()
  }

  test("hashing coding"){
    Melee1.hashCode()
    Distance1.hashCode()
    Siegue2.hashCode()
  }

  test("using super"){

  }

  test("comparing a weather card with himself") {
    assertEquals(NieblaImpenetrable.equals(NieblaImpenetrable), true)
    assertEquals(EscarchaMordiente.equals(EscarchaMordiente), true)
    assertEquals(LluviaTorrencial.equals(LluviaTorrencial), true)
    assertEquals(ClimaDespejado.equals(ClimaDespejado), true)
  }

  test("hashing code"){
    NieblaImpenetrable.hashCode()
    EscarchaMordiente.hashCode()
    LluviaTorrencial.hashCode()
    ClimaDespejado.hashCode()
  }

  test("to string method"){
    assertEquals(NieblaImpenetrable.toString(), "name: Niebla Impenetrable effect: Niebla Impenetrable")
  }

  test("playing weather cards"){
    NieblaImpenetrable.play()
  }

  test("comparing different weather cards") {
    assertEquals(NieblaImpenetrable.equals(EscarchaMordiente), false)
    assertEquals(NieblaImpenetrable.equals(1), false)
  }

  test("trying to create a unit with negative strength"){
    val caught = intercept[InvalidStrengthValue] {
      val test = new SiegeUnit("test", -10, NullEffectUnit)
    }
    assert(caught.getMessage == "El valor de la fuerza no puede inicializado negativo")
  }






}
