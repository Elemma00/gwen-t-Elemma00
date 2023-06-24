package cl.uchile.dcc
package gwent.model.cards.weathercards

import gwent.model.cards.ICard
import gwent.model.cards.effects.Effect
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

  var table: PlayerTable = _ 
  override def registerTable(o: PlayerTable): Unit = {
    table = o
  }

  /**
   * este método en realidad no notifica a la tabla pues por logica del juego, el efecto de las
   * cartas climas se aplica inmediatamente y solo una vez, entonces no necesitamos informarle al tablero
   * solo basta aplicarlo.
   */
  override def notifyTable(): Unit = {
    table.updateWeather(this)
  }
  override def placeOnTable(): Unit = {
    table.setCardWeather(this)
    notifyTable()
  }
  override def applyCardEffect(): Unit = {
    effect.applyEffect(this,table)
  }

  override def play(table: PlayerTable): Unit = {
    registerTable(table)
    placeOnTable()
  }
  override def lineEffect(effect: Effect): Unit = {println("Applied!!")}
  override def getName(): String = name
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

