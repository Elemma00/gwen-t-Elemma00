package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect

import gwent.model.cards.effects.Effect
import java.util.Objects

abstract class AbstractEffectWeather(private val name: String) extends Effect {
  def getName: String = name

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