package cl.uchile.dcc
package gwent.model.cards.effects.uniteffect

import gwent.model.cards.ICard
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.table.PlayerTable

import java.util.Objects
import scala.collection.mutable.ListBuffer


/**
 * a singleton Object that represent the effect "Refuerzo Moral"
 * this effect adds one point of strength to all cards in the same line
 */
object RefuerzoMoral extends AbstractEffectUnit("Refuerzo Moral") {
  var hasha : Int = 0
  override def applyEffect(card: ICard, tabla: PlayerTable): Unit = {
    hasha = card.hashCode()
    card.lineEffect(this)
  }
  override def distanceUnitEffect(list: List[DistanceUnit]): Unit = {
    for(distance <- list){
      if(distance.hashCode() != hasha) {
        distance.currentStrength += 1
        distance.strengthWithoutWeather += 1
      }
    }
  }
  override def meleeUnitEffect(list: List[MeleeUnit]): Unit = {
    for(melee <- list){
      if(melee.hashCode() != hasha) {
        melee.currentStrength += 1
        melee.strengthWithoutWeather += 1
      }
    }
  }
  override def siegueUnitEffect(list: List[SiegeUnit]): Unit = {
    for(siegue <- list){
      if(siegue.hashCode() != hasha) {
        siegue.currentStrength += 1
        siegue.strengthWithoutWeather += 1
      }
    }
  }





}
