package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.model.cards.effects.uniteffect.AbstractEffectUnit
import gwent.model.cards.unitscards.AbstractUnitCard
import gwent.model.table.PlayerTable

import cl.uchile.dcc.gwent.model.cards.effects.Effect

import java.util.Objects

/** A class representing a Melee Unit Card
 *
 *
 * @param name name of the Melee Unit
 * @param strength strength points
 * @param effect the card's effect
 * @author Elemma00
 */


class MeleeUnit(name: String, strength: Int, effect: AbstractEffectUnit)
  extends AbstractUnitCard(name, strength, effect) {
  
  override def notifyTable(): Unit = {
    table.updateMelee(this)
  }
  override def placeOnTable(): Unit = {
    table.setCardOnMeleeZone(this)
    notifyTable()
  }
  
  // this method calls the effect to apply it-self (single-dispatch)
  override def applyCardEffect(): Unit = {
    effect.applyEffect(this,table)
  }
  override def lineEffect(effect: Effect): Unit = {
    effect.meleeUnitEffect(table.getMeleeZone)
  }
  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[MeleeUnit]) {
      val other = o.asInstanceOf[MeleeUnit]
      (this eq other) ||
        other.name == name &&
          other.effect == effect &&
          other.strength == strength
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[MeleeUnit], name, strength, effect)
  }
}
