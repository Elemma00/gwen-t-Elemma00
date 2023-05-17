package cl.uchile.dcc
package test

import gwent.model.cards.effects.uniteffect.NullEffectUnit
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.table.{GeneralTable, PlayerTable}

import cl.uchile.dcc.gwent.model.cards.weathercards.NieblaImpenetrable

import java.awt.geom.GeneralPath

class TableTest extends munit.FunSuite {

  var tablaJugador1: PlayerTable = _
  var tablaJugador2: PlayerTable = _
  var tablaGeneral: GeneralTable = _
  var Siegue1: SiegeUnit = _
  var Distance1: DistanceUnit = _
  var Melee1: MeleeUnit = _
  var Melee2: MeleeUnit = _

  override def beforeEach(context: BeforeEach): Unit = {
    tablaJugador1 = new PlayerTable()
    tablaJugador2 = new PlayerTable()

    tablaGeneral = new GeneralTable(tablaJugador1,tablaJugador2)
    tablaJugador1.start(tablaGeneral)
    tablaJugador2.start(tablaGeneral)

    Siegue1 = new SiegeUnit("siegue1", 5,NullEffectUnit)
    Distance1 = new DistanceUnit("Distance1", 3,NullEffectUnit)
    Melee1 = new MeleeUnit("Melee1", 8,NullEffectUnit)
    Melee2 = new MeleeUnit("Melee2", 5,NullEffectUnit)



  }

  test("placing some units on table"){
    Siegue1.placeOnTable(tablaJugador1)
    Distance1.placeOnTable(tablaJugador2)
    Melee1.placeOnTable(tablaJugador1)
    Melee2.placeOnTable(tablaJugador2)
    println("tabla Jugador 1")
    tablaJugador1.showMyTable()
    println("\n tabla Jugador 2")
    tablaJugador2.showMyTable()
  }

  test("equals of PlayerTable"){
    assert(tablaJugador2.equals(tablaJugador1) == true)
  }

  test("test hashcode of PlayerTable"){
    println(tablaJugador2.hashCode())

  }

  test("equals and hash of general table"){
    assert(tablaGeneral.equals(tablaGeneral) == true)
    println(tablaGeneral.hashCode())
    println("hola")
  }

  test("setting a climate card"){

    tablaJugador2.setCardWeather(NieblaImpenetrable)
    println(tablaGeneral.weatherZone.toString)

  }
}
