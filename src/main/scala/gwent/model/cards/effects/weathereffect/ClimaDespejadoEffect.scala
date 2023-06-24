package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect
import gwent.model.cards.ICard
import gwent.model.table.PlayerTable

import scala.collection.mutable.ListBuffer

object ClimaDespejadoEffect extends AbstractEffectWeather("Clima Despejado"){
  override def applyEffect(card: ICard, table: PlayerTable): Unit ={
    table.setCardWeather(null)
    val melee = table.getMeleeZone
    val distance = table.getDistanceZone
    val siegue = table.getSiegueZone
    
    melee.foreach(u => u.currentStrength = u.strengthWithoutWeather)
    distance.foreach(u => u.currentStrength = u.strengthWithoutWeather)
    siegue.foreach(u => u.currentStrength = u.strengthWithoutWeather)
    
    println("Quito todos los efectos de cartas de clima que hayan en el campo")
  }
  
}
