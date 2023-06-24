package cl.uchile.dcc
package gwent.model.table

import gwent.model.cards.ICard
import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.cards.weathercards.AbstractWeatherCard
import gwent.model.player.Players
import gwent.model.table.GeneralTable
import java.util.Objects

import scala.collection.mutable.ListBuffer


/**
 * This class represents one side of the board that will be assigned to a single player.
 * siegueZone: An inmutable list containing siegue Units
 * distanceZone : An inmutable list containing distance Units
 * meleeZone : An inmutable list containing melee Units
 * asociatedTable : the General table that contains two playerTables
 */

class PlayerTable(){
  // Campo para el jugador
  private var siegueZone = List.empty[SiegeUnit]
  private var distanceZone = List.empty[DistanceUnit]
  private var meleeZone = List.empty[MeleeUnit]
  protected var asociatedTable: GeneralTable = _
  
  
  
  def updateMelee(o:ICard): Unit = {
    o.applyCardEffect()
  }
  def updateDistance (o:ICard): Unit = {
    o.applyCardEffect()
  }
  def updateSieuge (o:ICard): Unit = {
    o.applyCardEffect()
  }

  def updateWeather(o:ICard): Unit = {
    o.applyCardEffect()
  }
  def start(generalTable: GeneralTable) : Unit = {
    asociatedTable = generalTable
  }
  
  def getSiegueZone = siegueZone
  
  def getDistanceZone = distanceZone
  
  def getMeleeZone = meleeZone
  
  
  //Método para colocar una carta en el campo del player (double dispatch)
  def setCardOnTable(card:ICard): Unit = {
     card.placeOnTable()
  }

  def setCardOnSiegueZone(card: SiegeUnit) : Unit = {
    //En este caso, se crea una nueva lista siegueZone que contiene todas las unidades anteriores
    //seguidos de la nueva.
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
    println("***** Zona de Distancia *****")
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
    Objects.hash(classOf[PlayerTable],getSiegueZone,getMeleeZone,getDistanceZone)
  }

}
