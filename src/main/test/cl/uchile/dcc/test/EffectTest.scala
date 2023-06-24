package cl.uchile.dcc
package test

import gwent.model.cards.effects.uniteffect.{NullEffectUnit, RefuerzoMoral, VinculoEstrecho}
import gwent.model.cards.effects.weathereffect.{ClimaDespejadoEffect, EscarchaMordienteEffect, LluviaTorrencialEffect, NieblaImpenetrableEffect}
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.cards.weathercards.{ClimaDespejado, NieblaImpenetrable, LluviaTorrencial, EscarchaMordiente}
import gwent.model.table.{GeneralTable, PlayerTable}

class EffectTest extends munit.FunSuite {

  var tablaJugador1: PlayerTable = _
  var tablaJugador2: PlayerTable = _
  var tablaGeneral: GeneralTable = _
  var Siegue1: SiegeUnit = _
  var Siegue2: SiegeUnit = _
  var Distance1: DistanceUnit = _
  var Distance2: DistanceUnit = _
  var Melee1: MeleeUnit = _
  var Melee2: MeleeUnit = _
  var Dummy: MeleeUnit = _

  override def beforeEach(context: BeforeEach): Unit = {
    tablaJugador1 = new PlayerTable()
    tablaJugador2 = new PlayerTable()
    tablaGeneral = new GeneralTable(tablaJugador1, tablaJugador2)
    tablaJugador1.start(tablaGeneral)
    tablaJugador2.start(tablaGeneral)

    Melee1 = new MeleeUnit("melee1", 9, RefuerzoMoral)
    Melee2 = new MeleeUnit("melee1", 3, VinculoEstrecho)

    Siegue1 = new SiegeUnit("siegue1", 7, RefuerzoMoral)
    Siegue2 = new SiegeUnit("siegue2", 5, RefuerzoMoral)

    Distance1 = new DistanceUnit("Distance1", 10, VinculoEstrecho)
    Distance2 = new DistanceUnit("Distance1", 3, VinculoEstrecho)

    Dummy = new MeleeUnit("Distance1", 3, RefuerzoMoral)
  }

  test("every single effect is equal to himself") {
    assert(NullEffectUnit.equals(NullEffectUnit))
    assert(RefuerzoMoral.equals(RefuerzoMoral))
    assert(VinculoEstrecho.equals(VinculoEstrecho))
    assert(ClimaDespejadoEffect.equals(ClimaDespejadoEffect))
    assert(EscarchaMordienteEffect.equals(EscarchaMordienteEffect))
    assert(LluviaTorrencialEffect.equals(LluviaTorrencialEffect))
    assert(NieblaImpenetrableEffect.equals(NieblaImpenetrableEffect))
  }

  test("to string of every effect") {
    NullEffectUnit.toString
    RefuerzoMoral.toString
    VinculoEstrecho.toString
    ClimaDespejadoEffect.toString()
    EscarchaMordienteEffect.toString()
    LluviaTorrencialEffect.toString()
    NieblaImpenetrableEffect.toString()
  }

  test("comparing two weather effects that are not equal") {
    assertEquals(EscarchaMordienteEffect.equals(LluviaTorrencialEffect), false)
  }

  test("comparing two effect that are not equal") {
    assertEquals(NullEffectUnit.equals(NieblaImpenetrableEffect), false)
  }
  test("comparing two unit effect  that are not equal") {
    assertEquals(NullEffectUnit.equals(RefuerzoMoral), false)
  }

  test("hashCoding") {
    NullEffectUnit.hashCode()
    ClimaDespejadoEffect.hashCode()
  }

  test("Vinculo Estrecho test") {
    Distance1.play(tablaJugador1)
    Distance2.play(tablaJugador1)
    tablaJugador1.showMyTable()
    assert(Distance1.currentStrength == 20)
    assert(Distance2.currentStrength == 6)
  }

  test("Refuerzo Moral test") {
    Siegue1.play(tablaJugador1)
    Siegue2.play(tablaJugador1)
    tablaJugador1.showMyTable()
    assert(Siegue1.currentStrength == 8)
    assert(Siegue2.currentStrength == 5)
  }

  test("Clima Despejado test and Niebla Impenetrable") {
    Distance1.play(tablaJugador1)
    Distance2.play(tablaJugador1)
    assert(Distance1.currentStrength == 20)
    assert(Distance2.currentStrength == 6)
    NieblaImpenetrable.play(tablaJugador1)
    assert(Distance1.currentStrength == 21)
    assert(Distance2.currentStrength == 7)
    ClimaDespejado.play(tablaJugador1)
    assert(Distance1.currentStrength == 20)
    assert(Distance2.currentStrength == 6)
    tablaGeneral.showAll()
  }

  test("Lluvia Torrencial test"){
    Siegue1.play(tablaJugador1)
    Siegue2.play(tablaJugador1)
    assert(Siegue1.currentStrength == 8)
    assert(Siegue2.currentStrength == 5)
    LluviaTorrencial.play(tablaJugador1)
    assert(Siegue1.currentStrength == 1)
    assert(Siegue2.currentStrength == 1)
    ClimaDespejado.play(tablaJugador1)
    assert(Siegue1.currentStrength == 8)
    assert(Siegue2.currentStrength == 5)
  }

  test("Escarcha Mordiente test"){
    Melee1.play(tablaJugador1)
    Melee2.play(tablaJugador1)
    assert(Melee1.currentStrength == 18)
    assert(Melee2.currentStrength == 6)
    EscarchaMordiente.play(tablaJugador1)
    assert(Melee1.currentStrength == 19)
    assert(Melee2.currentStrength == 7)
    ClimaDespejado.play(tablaJugador1)
    assert(Melee1.currentStrength == 18)
    assert(Melee2.currentStrength == 6)

  }


  test("effect applies in every zone"){
    NieblaImpenetrableEffect.meleeUnitEffect(tablaJugador1.getMeleeZone)
    NieblaImpenetrableEffect.distanceUnitEffect(tablaJugador1.getDistanceZone)
    NieblaImpenetrableEffect.siegueUnitEffect(tablaJugador1.getSiegueZone)
  }

  test("effect applies in every zone") {
    VinculoEstrecho.meleeUnitEffect(tablaJugador1.getMeleeZone)
    VinculoEstrecho.distanceUnitEffect(tablaJugador1.getDistanceZone)
    VinculoEstrecho.siegueUnitEffect(tablaJugador1.getSiegueZone)
  }

  test("equals effect with any object"){
    ClimaDespejadoEffect.equals(1)
    NieblaImpenetrableEffect.equals("glksjdflk")
  }




}
