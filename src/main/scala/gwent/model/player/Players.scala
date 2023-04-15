package cl.uchile.dcc
package gwent.model.player

import gwent.model.cards.ICard
import gwent.model.cards.deck.Deck

import scala.collection.mutable.ListBuffer

/**
 * a class that represents a player
 * Player is defined by a name, gems and deck
 *
 * @param name player's name
 * @param gems amount of gems
 * @param deck a list of cards that the user have
 *
 *
 */

class Players(private val name: String, private var gems: Int, private val deck:Deck) {

  // a list of cards that the user have in hand
  private var onHandCards: List[ICard] = List.empty[ICard]

  // this method is for play a card
  def playCard(cardPlayed: ICard): Unit = {}

  // draw a card of the deck and put in on hand
  def drawCard(): Unit = {
     onHandCards = onHandCards :+ deck.draw()
  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[Players]) {
      val other = o.asInstanceOf[Players]
      (this eq other) ||
        other.name == name &&
          other.gems == gems
    } else {
      false
    }
  }


}
