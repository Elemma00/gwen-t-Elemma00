package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.model.cards.ICard
import gwent.model.cards.effects.uniteffect.AbstractEffectUnit

import java.util.Objects

/** An abstract class representing a Unit Card
 *
 * a Unit card is defined by a name, strength and its effect
 *
 * @param name     name of the Unit
 * @param strength strength points
 * @param effect   the card's effect
 * @author Elemma00
 */


abstract class AbstractUnitCard (val name: String, val strength: Int, protected val effect: AbstractEffectUnit)
  extends ICard {
  

  // this method calls the effect to apply it-self
  override def applyCardEffect(): Unit = {
    effect.applyEffect()
  }

  override def play(/* posicion en tabla: Int */): Unit = {
    //placeOnTable()
    applyCardEffect()
  }
  override def toString: String = {
    s"name: $name strength: $strength effect: ${effect.getName}"
  }
}
