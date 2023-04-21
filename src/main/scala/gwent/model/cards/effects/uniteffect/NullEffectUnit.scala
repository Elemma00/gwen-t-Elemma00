package cl.uchile.dcc
package gwent.model.cards.effects.uniteffect

import java.util.Objects


/**
 * 
 * A singleton object that represent a null effect, in case we have a unit without effect we use this 
 * PD: I've applied the singleton pattern design 
 *
 * @author: Elemma00
 */
object NullEffectUnit extends AbstractEffectUnit("NullEffect") {
  override def applyEffect(): Unit = {
    println("no tengo efecto jaja salu2")
  }

}
