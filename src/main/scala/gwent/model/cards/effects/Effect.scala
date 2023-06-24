package cl.uchile.dcc
package gwent.model.cards.effects

import gwent.model.cards.ICard
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.table.PlayerTable

/**
 * a trait for effects
 */
trait Effect {
  //this method apply the effect on game
  def applyEffect(card:ICard, table: PlayerTable): Unit
  def siegueUnitEffect(list: List[SiegeUnit]):Unit
  def distanceUnitEffect(list:List[DistanceUnit]):Unit
  def meleeUnitEffect(list: List[MeleeUnit]):Unit

}
