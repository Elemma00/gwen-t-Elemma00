package cl.uchile.dcc
package gwent.model.player

import gwent.model.cards.ICard

import scala.collection.mutable.ListBuffer

class Players(private val name: String, private val gems: Int) {

  var onHandCards: ListBuffer[ICard] = ListBuffer.empty[ICard]

  def playCard(cardPlayed: ICard): Unit = {}

  def drawCard(): Unit = {}

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Players]) {
      val o = other.asInstanceOf[Players]
      if (this.name == o.name) {
        if (this.gems == o.gems) {
          true
        } else false
      } else false
    } else false

  }



}
