package cl.uchile.dcc
package gwent.model.cards.weathercards

import gwent.model.cards.ICard
import gwent.model.cards.effects.weathereffect.AbstractEffectWeather
import gwent.model.table.PlayerTable

import java.util.Objects


/**
 *  An abstract class representing a Weather Card
 *
 * @param name name of the card
 * @param effect the card's effect
 */
abstract class AbstractWeatherCard(val name: String, private val effect: AbstractEffectWeather) extends ICard{
  override def placeOnTable(table: PlayerTable): Unit = {
    table.setCardWeather(this)
  }
  override def applyCardEffect(): Unit = {
    effect.applyEffect()
  }

  override def play(): Unit = {
    //placeOnTable()
    applyCardEffect()
  }
  override def toString: String = {
    s"name: $name effect: ${effect.toString()}"
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

  override def hashCode(): Int = {
    Objects.hash(classOf[AbstractWeatherCard],name,effect)
  }


}

