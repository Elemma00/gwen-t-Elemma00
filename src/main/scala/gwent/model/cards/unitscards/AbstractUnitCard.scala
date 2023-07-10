package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.exceptions.InvalidStrengthValue
import gwent.model.cards.ICard
import gwent.model.cards.effects.Effect
import gwent.model.cards.effects.uniteffect.AbstractEffectUnit
import gwent.model.table.PlayerTable

import java.util.Objects

/** An abstract class representing a Unit Card
 *
 * a Unit card is defined by a name, strength and its effect
 *
 * @param name      name of the Unit
 * @param strength  strength points
 * @param effect    the card's effect
 * @param table     the associated played table
 * @param currentStrength  current strength points
 * @param strengthWithoutWeather  strength points without considering the weather card buff
 * @author Elemma00
 */


abstract class AbstractUnitCard (val name: String, val strength: Int, protected val effect: AbstractEffectUnit)
  extends ICard {

  var table: PlayerTable = _
  var currentStrength: Int = strength
  var strengthWithoutWeather = strength
  var buffWeather: Int = 0
  override def registerTable(o: PlayerTable): Unit = {
    table = o
  }

  try {
    if (strength < 0) {
      throw new InvalidStrengthValue("El valor de la fuerza no puede inicializado negativo")
    }
  }

  def play(tabla:PlayerTable): Unit = {
    registerTable(tabla)
    placeOnTable()
  }
  override def getName(): String = name
  override def toString: String = {
    s"Name: $name CurrentStrength: $currentStrength Strength: $strength Effect: ${effect.getName}"
  }
}
