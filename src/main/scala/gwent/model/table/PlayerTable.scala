package cl.uchile.dcc
package gwent.model.table

import gwent.model.cards.ICard
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.player.Players

import scala.collection.mutable.ListBuffer

class Table(player1: Players, player2 : Players) {

  // Campo para el jugador 1
  protected var siegueZone1 = ListBuffer.empty[ICard]
  protected var distanceZone1 = ListBuffer.empty[ICard]
  protected var meleeZone1 = ListBuffer.empty[ICard]

  // Campo para el jugador 2
  protected var siegueZone2 = ListBuffer.empty[ICard]
  protected var distanceZone2 = ListBuffer.empty[ICard]
  protected var meleeZone2 = ListBuffer.empty[ICard]

  //Campo común de cartas de clima
  protected val weatherZone = ListBuffer.fill(1)

  //Método para colocar una carta en el campo del player 1
  def setCardOnTable1(card:ICard): Unit = {
     card.placeOnTable1(this)
  }
  
  def setCardOnTable2(card:ICard) : Unit = {
    card.placeOnTable2()
  }



}
