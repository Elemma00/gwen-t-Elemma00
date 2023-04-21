package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.model.cards.effects.uniteffect.AbstractEffectUnit
import gwent.model.cards.unitscards.AbstractUnitCard

import java.util.Objects


/** A class representing a Siege Unit Card
 *
 * @param name     name of the Siegue Unit
 * @param strength strength points
 * @param effect   the effect's card
 * @author Elemma00
 */

class SiegeUnit(name: String, strength: Int, effect: AbstractEffectUnit)
  extends AbstractUnitCard(name, strength, effect) {

  // override def placeOnTable(/* table:Table */): Unit = {}
  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[SiegeUnit]) {
      val other = o.asInstanceOf[SiegeUnit]
      (this eq other) ||
        other.name == name &&
          other.effect == effect &&
          other.strength == strength
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[SiegeUnit], name, strength, effect)
  }

}
