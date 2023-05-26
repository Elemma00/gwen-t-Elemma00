package cl.uchile.dcc
package gwent.model.table

import gwent.model.cards.ICard
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.cards.weathercards.AbstractWeatherCard
import gwent.model.player.Players
import gwent.model.table.GeneralTable
import java.util.Objects


class PlayerTable(){


  // Campo para el jugador
  protected var siegueZone = List.empty[ICard]
  protected var distanceZone = List.empty[ICard]
  protected var meleeZone = List.empty[ICard]
  protected var asociatedTable: GeneralTable = _

  def start(generalTable: GeneralTable) : Unit = {
    asociatedTable = generalTable
  }

  //Método para colocar una carta en el campo del player (double dispatch)
  def setCardOnTable(card:ICard): Unit = {
     card.placeOnTable(this)
  }

  def setCardOnSiegueZone(card: SiegeUnit) : Unit = {
     siegueZone = siegueZone :+ card
  }
  
  def setCardOnDistanceZone(card: DistanceUnit): Unit = {
    distanceZone = distanceZone :+ card
  }
  
  def setCardOnMeleeZone(card: MeleeUnit): Unit = {
    meleeZone = meleeZone :+ card
  }

  def setCardWeather(card: AbstractWeatherCard): Unit = {
    asociatedTable.setWeatherCard(card)
  }


  def showMyTable(): Unit ={
    println("***** Zona de Asedio *****")
    siegueZone.foreach{
      carta => println(carta.toString)
    }
    println("***** Zona de Cuerpo a cuerpo *****")
    meleeZone.foreach{
      carta => println(carta.toString)
    }
    println("***** Zone de Distancia *****")
    distanceZone.foreach{
      carta => println(carta.toString)
    }


  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[PlayerTable]) {
      val other = o.asInstanceOf[PlayerTable]
      (this eq other) ||
        other.siegueZone == siegueZone &&
          other.distanceZone == distanceZone &&
           other.meleeZone == meleeZone
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[PlayerTable], siegueZone, distanceZone, meleeZone)
  }

}
