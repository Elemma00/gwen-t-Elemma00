package cl.uchile.dcc
package gwent.model.cards.deck

import gwent.model.cards.ICard
import scala.util.Random

class Deck(private var list: List[ICard]) {


  def suffle(): Unit = {
    list = Random.shuffle(list)
  }

  def draw(): ICard = {
    var card = list.last
    list = list.init
    card
  }

}
