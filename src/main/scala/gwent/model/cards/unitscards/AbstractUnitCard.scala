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


abstract class AbstractUnitCard (private val name: String, private val strength: Int, private val effect: AbstractEffectUnit)
  extends ICard {

  // getter methods
  override def getName: String = name
  def getStrength: Int = strength
  def getEffect: AbstractEffectUnit = effect


  // this method calls the effect to apply it-self
  override def applyCardEffect(): Unit = {
    effect.applyEffect()
  }

  override def play(): Unit = {
    //placeOnTable()
    applyCardEffect()
  }
  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[AbstractUnitCard]) {
      val other = o.asInstanceOf[AbstractUnitCard]
      (this eq other) ||
        other.name == name &&
          other.effect == effect &&
          other.strength == strength
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[AbstractUnitCard], name, strength,effect)
  }

  override def toString: String = {
    s"name: $name strength: $strength effect: ${effect.getName}"
  }
}
