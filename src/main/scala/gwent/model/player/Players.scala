package cl.uchile.dcc
package gwent.model.player

import gwent.model.cards.ICard
import gwent.model.cards.deck.Deck

import java.util.Objects


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

class Players(private val name: String, private var gems: Int, private val deck: Deck) {

  // a list of cards that the user have in hand
  private var onHandCards = new Deck(List.empty[ICard])

  def showHandCards(): Unit = {
    onHandCards.showcards()
  }

  // this method is for play a card
  def playCard(cardPlayed: ICard): Unit = {
    onHandCards.setList(onHandCards.getList.filter(_ != cardPlayed))
    cardPlayed.applyCardEffect()
  }

  // draw a card of the deck and put in on hand
  def drawCard(): Unit = {
    val drawCard = deck.draw()
    onHandCards.setList(onHandCards.getList :+ drawCard)
  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[Players]) {
      val other = o.asInstanceOf[Players]
      (this eq other) ||
        other.name == name &&
          other.gems == gems &&
          other.deck == deck
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[Players], name, gems, deck)
  }


  def getName: String = name

  def getGems: Int = gems

  def getDeck: Deck = deck

  def getOnHandCards: Deck = onHandCards

}
