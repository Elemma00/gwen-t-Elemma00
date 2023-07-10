package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect

import gwent.model.cards.effects.Effect

import cl.uchile.dcc.gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}

import java.util.Objects

abstract class AbstractEffectWeather(protected val name: String) extends Effect {

  override def distanceUnitEffect(list: List[DistanceUnit]): Unit = println("Do Nothing")
  override def meleeUnitEffect(list: List[MeleeUnit]): Unit = println("Do Nothing")
  override def siegueUnitEffect(list: List[SiegeUnit]): Unit = println("Do Nothing")
 override def toString: String = name
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