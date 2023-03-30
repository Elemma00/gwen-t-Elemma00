package cl.uchile.dcc
package gwent.model.player

import gwent.model.cards.{ICard, Deck}

import scala.collection.mutable.ListBuffer

class Players(private val nombre: String, private val gems: Int, private var deck: Deck) {

  var onHandCards: ListBuffer[ICard] = ListBuffer.empty[ICard]

  def playCard(cardPlayed: ICard): Unit = {}

  def drawCard(): Unit = {}


}
