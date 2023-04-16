package cl.uchile.dcc
package gwent.model.cards.effects.uniteffect

import gwent.model.cards.effects.Effect

import java.util.Objects


/**
 * An abstract class that represent the effects that a card have
 * @param name the name of the effect
 *        
 * I use this abstract class in addition to the singleton pattern design because
 * in that way we have a extensible class if we want more effects in new updates
 */
abstract class AbstractEffectUnit(private val name: String) extends Effect {
  def getName: String = name
  
  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[AbstractEffectUnit]) {
      val other = o.asInstanceOf[AbstractEffectUnit]
      (this eq other) ||
        other.name == name
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[AbstractEffectUnit], name)
  }
}
