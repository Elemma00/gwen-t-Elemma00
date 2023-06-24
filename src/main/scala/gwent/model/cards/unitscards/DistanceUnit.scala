package cl.uchile.dcc
package gwent.model.cards.unitscards


import gwent.model.cards.ICard
import gwent.model.cards.effects.uniteffect.AbstractEffectUnit
import gwent.model.cards.unitscards.AbstractUnitCard
import gwent.model.table.PlayerTable

import cl.uchile.dcc.gwent.model.cards.effects.Effect

import java.util.Objects

/** A class representing a Distance Unit Card
 *
 *
 * @param name     name of the Distance Unit
 * @param strength point of strength
 * @param effect   the effect's card
 * @author Elemma00
 */

class DistanceUnit (name: String, strength: Int, effect: AbstractEffectUnit)
  extends AbstractUnitCard(name, strength, effect) {

  override def notifyTable(): Unit = {
    table.updateDistance(this)
  }
  override def placeOnTable(): Unit = {
    table.setCardOnDistanceZone(this)
    notifyTable()
  }

  override def lineEffect(effect: Effect): Unit = {
    effect.distanceUnitEffect(table.getDistanceZone)
  }


  // this method calls the effect to apply it-self (single-dispatch)
  override def applyCardEffect(): Unit = {
    effect.applyEffect(this,table)
  }


  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[DistanceUnit]) {
      val other = o.asInstanceOf[DistanceUnit]
      (this eq other) ||
        other.name == name &&
          other.effect == effect &&
          other.strength == strength
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[DistanceUnit], name, strength, effect)
  }
  
}
