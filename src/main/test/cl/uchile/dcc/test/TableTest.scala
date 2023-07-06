package cl.uchile.dcc
package test

import gwent.model.cards.effects.uniteffect.NullEffectUnit
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.cards.weathercards.NieblaImpenetrable
import gwent.model.table.{GeneralTable, PlayerTable}

import java.awt.geom.GeneralPath

class TableTest extends munit.FunSuite {

  var tablaJugador1: PlayerTable = _
  var tablaJugador2: PlayerTable = _
  var tablaJugador3: PlayerTable = _
  var tablaJugador4: PlayerTable = _
  var dummyJugador: PlayerTable = _
  var tablaGeneral: GeneralTable = _
  var tablaFoo: GeneralTable = _
  var Siegue1: SiegeUnit = _
  var Distance1: DistanceUnit = _
  var Melee1: MeleeUnit = _
  var Melee2: MeleeUnit = _

  override def beforeEach(context: BeforeEach): Unit = {
    tablaJugador1 = new PlayerTable()
    tablaJugador2 = new PlayerTable()
    tablaJugador3 = new PlayerTable()
    tablaJugador4 = new PlayerTable()
    dummyJugador = new PlayerTable()

    tablaGeneral = new GeneralTable(tablaJugador1,tablaJugador2)
    tablaFoo = new GeneralTable(dummyJugador,tablaJugador4)

    tablaJugador1.start(tablaGeneral)
    tablaJugador2.start(tablaGeneral)

    Siegue1 = new SiegeUnit("siegue1", 5,NullEffectUnit)
    Distance1 = new DistanceUnit("Distance1", 3,NullEffectUnit)
    Melee1 = new MeleeUnit("Melee1", 8,NullEffectUnit)
    Melee2 = new MeleeUnit("Melee2", 5,NullEffectUnit)

  }

  test("placing some units on table"){
    Melee1.registerTable(tablaJugador2)
    Distance1.registerTable(tablaJugador1)
    Siegue1.registerTable(tablaJugador2)
    tablaJugador2.setCardOnTable(Melee1)
    tablaJugador1.setCardOnTable(Distance1)
    tablaJugador2.setCardOnTable(Siegue1)
    println("tabla Jugador 1")
    tablaJugador1.showMyTable()
    println("\n tabla Jugador 2")
    tablaJugador2.showMyTable()

  }

  test("equals of PlayerTable "){
    assert(tablaJugador2.equals(tablaJugador1) == true)
  }

  test("test hashcode of PlayerTable"){
    Melee1.registerTable(tablaJugador2)
    tablaJugador2.setCardOnTable(Melee1)
    assert(tablaJugador2.hashCode() != tablaJugador1.hashCode())
    assert(tablaJugador2.getSiegueZone == tablaJugador3.getSiegueZone)
    assert(tablaJugador2.getDistanceZone == tablaJugador3.getDistanceZone)
    assert(tablaJugador2.getMeleeZone != tablaJugador3.getMeleeZone)
  }

  test("equals and hash of general table"){
    assert(tablaGeneral.equals(tablaGeneral) == true)
    assert(!tablaGeneral.equals(tablaJugador3))
    println(tablaGeneral.hashCode())

  }

  test("setting a climate card"){
    tablaGeneral.setWeatherCard(NieblaImpenetrable)
    println(tablaGeneral.weatherZone.toString)
  }

  test("equals with any object"){
    tablaJugador1.equals(1)
    tablaJugador2.equals("sdkfjokdsjf")
  }
}
