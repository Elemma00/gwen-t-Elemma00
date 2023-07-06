package cl.uchile.dcc
package test

import gwent.controller.Controller
import gwent.controller.states.TurnsHandler
import gwent.model.table.{GeneralTable, PlayerTable}
import gwent.model.player.Players
import gwent.model.cards.ICard
import gwent.model.cards.deck.Deck
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}

import cl.uchile.dcc.gwent.model.cards.effects.uniteffect.NullEffectUnit

class NotifyTest extends munit.FunSuite {

  var controller: Controller = _
  var tablaJugador1: PlayerTable = _
  var tablaJugador2: PlayerTable = _
  var tablaGeneral: GeneralTable = _
  var jugador1: Players = _
  var jugador2: Players = _
  var deck1: Deck = _
  var deck2: Deck = _
  var siegue1: SiegeUnit = _
  var distanceUnit1: DistanceUnit = _
  var meleeGenerico1: MeleeUnit = _
  var meleeGenerico2: MeleeUnit = _

  override def beforeEach(context: BeforeEach): Unit = {

    siegue1 = new SiegeUnit("SiegeGenerico", 10, NullEffectUnit)
    distanceUnit1 = new DistanceUnit("DistanceGenerico", 10, NullEffectUnit)
    meleeGenerico1 = new MeleeUnit("MeleeGenerico1", 20, NullEffectUnit)
    meleeGenerico2 = new MeleeUnit("MeleeGenerico2", 20, NullEffectUnit)

    val lista1: List[ICard] = List(siegue1, distanceUnit1)
    val lista2: List[ICard] = List(meleeGenerico1, meleeGenerico2)

    deck1 = new Deck(lista1)
    deck2 = new Deck(lista2)

    controller = new Controller()

    tablaJugador1 = new PlayerTable()
    tablaJugador2 = new PlayerTable()

    jugador1 = new Players("jugador1", 1, deck1, tablaJugador1)
    jugador2 = new Players("jugador2", 1, deck1, tablaJugador2)

    tablaGeneral = new GeneralTable(tablaJugador1,tablaJugador2)

    tablaJugador1.start(tablaGeneral)
    tablaJugador2.start(tablaGeneral)
    tablaGeneral.setPlayers(jugador1,jugador2)
    tablaGeneral.registerControllerObserver(controller)

  }

  test("changing default init state of controller"){
    controller.setState(new TurnsHandler())
    assert(controller.isTurnsHandler())
  }

  test("testing game over notification"){
   //in this test we assume that the current state is TurnsHandler-State
   //then we simulate that player2 lost the round and loses his last gem.
   //At this point we are going to check
   //the End Game notification and the update of the state.
    controller.setState(new TurnsHandler())

    println(jugador1.toString)
    println(jugador2.toString)
    jugador1.drawCard()
    jugador1.playCard(0)
    tablaGeneral.roundWinner()
    println(jugador1.toString)
    println(jugador2.toString)
    assert(controller.isEndGame())
  }


}
