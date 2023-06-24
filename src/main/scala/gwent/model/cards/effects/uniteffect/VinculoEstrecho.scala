package cl.uchile.dcc
package gwent.model.cards.effects.uniteffect

import gwent.model.cards.ICard
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.table.PlayerTable

import scala.collection.mutable.ListBuffer


/**
 * a singleton object that represent the effect "Vinculo Estrecho"
 * this effect doubles the strength points of every card that have the same name, including himself
 */
object VinculoEstrecho extends AbstractEffectUnit("Vinculo Estrecho") {

  override def applyEffect(card: ICard, table: PlayerTable): Unit = {
    val name: String = card.getName()
    val hasha: Int = card.hashCode()

    val meleeZone = table.getMeleeZone
    val siegueZone = table.getSiegueZone
    val distanceZone = table.getDistanceZone

    val listaDistance: ListBuffer[DistanceUnit] = ListBuffer.empty
    val listaSiegue: ListBuffer[SiegeUnit] = ListBuffer.empty
    val listaMelee: ListBuffer[MeleeUnit] = ListBuffer.empty



    for (melee <- meleeZone) {
      if (melee.getName() == name) {
        listaMelee.append(melee)
      }
    }

    if (listaMelee.length > 1) {
      listaMelee.foreach {
        d =>
          d.currentStrength *= 2
          d.strengthWithoutWeather *= 2
      }
    }

    for (siegue <- siegueZone) {
      if (siegue.getName() == name) {
        listaSiegue.append(siegue)
      }
    }

    if (listaSiegue.length > 1) {
      listaSiegue.foreach{
        d => d.currentStrength *= 2
        d.strengthWithoutWeather *= 2}
    }


    for (distance <- distanceZone) {
      if (distance.getName() == name) {
        listaDistance.append(distance)
      }
    }

    if (listaDistance.length > 1) {
      listaDistance.foreach {
        d =>
          d.currentStrength *= 2
          d.strengthWithoutWeather *= 2
      }
    }

  }
}
