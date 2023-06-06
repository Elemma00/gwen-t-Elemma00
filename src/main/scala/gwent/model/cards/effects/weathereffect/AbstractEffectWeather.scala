package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect

import gwent.model.cards.effects.Effect
import java.util.Objects

abstract class AbstractEffectWeather(protected val name: String) extends Effect {

 override def toString(): String = {
    name
  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[AbstractEffectWeather]) {
      val other = o.asInstanceOf[AbstractEffectWeather]
      (this eq other) ||
        other.name == name
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[AbstractEffectWeather], name)
  }
}