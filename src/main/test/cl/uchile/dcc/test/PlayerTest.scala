package cl.uchile.dcc
package test

import gwent.exceptions.InvalidGemsAmount
import gwent.model.cards.ICard
import gwent.model.cards.deck.Deck
import gwent.model.cards.effects.uniteffect.NullEffectUnit
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.player.Players

import cl.uchile.dcc.gwent.model.table.{GeneralTable, PlayerTable}


class PlayerTest extends munit.FunSuite {

  var player1: Players = _
  var player2: Players = _
  var player3: Players = _
  var deck1: Deck = _
  var deck2: Deck = _
  var siegue1: SiegeUnit = _
  var distanceUnit1: DistanceUnit = _
  var meleeGenerico1: MeleeUnit = _
  var meleeGenerico2: MeleeUnit = _
  var tablaJugador1: PlayerTable = _
  var tablaJugador2: PlayerTable = _
  var tablaJugador3: PlayerTable = _
  var tablaGeneral: GeneralTable = _

  override def beforeEach(context: BeforeEach): Unit = {
    siegue1 = new SiegeUnit("SiegeGenerico", 10, NullEffectUnit)
    distanceUnit1 = new DistanceUnit("DistanceGenerico", 10, NullEffectUnit)
    meleeGenerico1 = new MeleeUnit("MeleeGenerico1", 20, NullEffectUnit)
    meleeGenerico2 = new MeleeUnit("MeleeGenerico2", 20, NullEffectUnit)
    tablaJugador1 = new PlayerTable()
    tablaJugador2 = new PlayerTable()
    tablaJugador3 = new PlayerTable()

    val lista1: List[ICard] = List(siegue1, distanceUnit1)
    val lista2: List[ICard] = List(meleeGenerico1, meleeGenerico2)

    deck1 = new Deck(lista1)
    deck2 = new Deck(lista2)

    player1 = new Players("nombrexd", 2, deck1, tablaJugador1)
    player2 = new Players("player2", 2, deck2, tablaJugador2)
    player3 = new Players("player2", 2, deck2, tablaJugador3)

    tablaGeneral = new GeneralTable(tablaJugador1,tablaJugador2)
    
  }


  test("equal player addresses") {
    assertEquals(player2.equals(player3), true)
  }

  test("equal player values") {
    assertEquals(player2.equals(player3), true)
  }

  test("not equal player values") {
    player2.equals(player1)
  }


  test("drawing a card and play") {
    println("At this moment the player has no card on hands")
    player1.showHandCards()
    println("Now the player will draw a card from his deck")
    player1.drawCard()
    player1.showHandCards()
    player1.playCard(0)
  }

  test("hash code for players") {
    assert(player2.hashCode() != player1.hashCode())
  }
  test("showing the cards in the hand of a player") {
    player1.drawCard()
    player1.showHandCards()
  }

  test("showing the deck of a player") {
    player1.showMyDeck()
  }

  test("shuffling the deck") {
    println("deck sin barajar")
    player1.showMyDeck()
    player1.shuffleDeck()
    println("ya barajamos ")
    player1.showMyDeck()
  }
  test("append a card on deck"){
    deck1.append(siegue1)
  }

  test("comparing deck 1 and deck 2"){
   assertEquals(deck1.equals(deck2),false)
  }

  test("checking if player still alive"){

    assert(player2.isAlive())
    player2.gems -= 3
    assert(!player2.isAlive())
  }

  test("checking if player is initialized with negative gems"){

    val caught = intercept[InvalidGemsAmount] {
      val player = new Players("John", -10, deck1, tablaJugador1)
    }
    assert(caught.getMessage == "El numero de gemas no puede inicializado negativo")
  }
}
