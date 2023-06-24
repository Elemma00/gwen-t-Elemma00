package cl.uchile.dcc
package test

import gwent.model.cards.effects.uniteffect.{NullEffectUnit, RefuerzoMoral, VinculoEstrecho}
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.cards.weathercards.{ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable}
import gwent.model.table.{GeneralTable, PlayerTable}

import java.awt.geom.GeneralPath

class ObserverTest extends munit.FunSuite {

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

    Siegue1 = new SiegeUnit("siegue1", 5, RefuerzoMoral)
    Siegue2 = new SiegeUnit("siegue2", 5, RefuerzoMoral)

    Distance1 = new DistanceUnit("Distance1", 3, VinculoEstrecho)
    Distance2 = new DistanceUnit("Distance1", 3, VinculoEstrecho)

    Dummy = new MeleeUnit("Distance1", 3, RefuerzoMoral)
  }

  test("placing some units on table") {
    Distance2.play(tablaJugador1)
    Distance1.play(tablaJugador1)
    Siegue1.play(tablaJugador2)
    Siegue2.play(tablaJugador2)

    println("\ntabla Jugador 1")
    tablaJugador1.showMyTable()
    println("\ntabla Jugador 2")
    tablaJugador2.showMyTable()
  }

  test("Notifying the table that distance cards were played ") {
    Distance1.registerTable(tablaJugador1)
    Distance2.registerTable(tablaJugador1)
    tablaJugador1.setCardOnDistanceZone(Distance1)
    tablaJugador1.setCardOnDistanceZone(Distance2)
    Distance2.notifyTable()
    tablaJugador1.showMyTable()
  }

  test("Notifying the table that melee cards were played ") {
    Melee1.registerTable(tablaJugador1)
    Melee2.registerTable(tablaJugador1)
    tablaJugador1.setCardOnMeleeZone(Melee1)
    tablaJugador1.setCardOnMeleeZone(Melee2)
    Melee2.notifyTable()
    tablaJugador1.showMyTable()
  }

  test("Notifying the table that siegue cards were played ") {
    Siegue1.registerTable(tablaJugador1)
    Siegue2.registerTable(tablaJugador1)
    tablaJugador1.setCardOnSiegueZone(Siegue1)
    tablaJugador1.setCardOnSiegueZone(Siegue2)
    Siegue2.notifyTable()
    tablaJugador1.showMyTable()
  }


  test("Notifying the table that clima Despejado was played ") {
    ClimaDespejado.registerTable(tablaJugador1)
    tablaJugador1.setCardWeather(ClimaDespejado)
    ClimaDespejado.notifyTable()
    tablaGeneral.showAll()
  }

  test("Notifying the table that Niebla Impenetrable was played ") {
    NieblaImpenetrable.registerTable(tablaJugador1)
    tablaJugador1.setCardWeather(NieblaImpenetrable)
    NieblaImpenetrable.notifyTable()
    tablaGeneral.showAll()
  }

  test("Notifying the table that Lluvia torrencial was played ") {
    LluviaTorrencial.registerTable(tablaJugador1)
    tablaJugador1.setCardWeather(LluviaTorrencial)
    LluviaTorrencial.notifyTable()
    tablaGeneral.showAll()
  }

  test("Notifying the table that Escarcha Mordiente was played ") {
    EscarchaMordiente.registerTable(tablaJugador1)
    tablaJugador1.setCardWeather(EscarchaMordiente)
    EscarchaMordiente.notifyTable()
    tablaGeneral.showAll()
  }


}