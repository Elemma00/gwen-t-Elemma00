package cl.uchile.dcc
package gwent.model.cards.deck

import gwent.model.cards.ICard

import java.util.Objects
import scala.util.Random

class Deck(private var list: List[ICard]) {

  def getList = list
  def setList(nuevaLista:List[ICard]) = {
    list = nuevaLista
  }
  def showcards(): Unit ={
    for (elemento <- list) {
      println(elemento.toString)
    }
  }
  def suffle(): Unit = {
    list = Random.shuffle(list)
  }

  def draw(): ICard = {
    var card = list.last
    list = list.init
    card
  }
  def append(card: ICard):Unit = {
    list = list :+ card
  }


  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[Deck]) {
      val other = o.asInstanceOf[Deck]
      (this eq other) ||
        other.list == list
    } else {
      false
    }
  }
  override def hashCode(): Int = {
    Objects.hash(classOf[Deck],list)
  }


}
