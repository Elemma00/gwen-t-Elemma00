package cl.uchile.dcc
package gwent.model.cards.weathercards

import gwent.model.cards.effects.AbstractEffect
import gwent.model.cards.ICard


/**
 *  An abstract class representing a Weather Card
 *
 * @param name name of the card
 * @param effect the card's effect
 */
abstract class AbstractWeatherCard(private val name: String, private val effect: AbstractEffect) extends ICard{

  def getName: String = name
  def getEffect: AbstractEffect = effect


// override def placeOnTable(/* table:Table */): Unit = {}

  override def applyCardEffect(): Unit = {
    effect.applyEffect()
  }

  override def toString: String = {
    s"name: $name strength: ${effect.getName}"
  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[AbstractWeatherCard]){
      val other = o.asInstanceOf[AbstractWeatherCard]
      (this eq other) ||
        other.name == name &&
          other.effect == effect
    } else{
      false
    }
  }


}

