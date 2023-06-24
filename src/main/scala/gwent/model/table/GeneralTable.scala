package cl.uchile.dcc
package gwent.model.table

import gwent.model.cards.ICard
import gwent.model.cards.weathercards.AbstractWeatherCard
import gwent.model.table.PlayerTable

import scala.collection.mutable.ArrayBuffer
import java.util.Objects


class GeneralTable(val tablePlayer1: PlayerTable, val tablePlayer2: PlayerTable)  {

  //Campo común de cartas de clima
  var weatherZone: AbstractWeatherCard = _
  
  def setWeatherCard(card:AbstractWeatherCard) : Unit = {
    weatherZone = card
  }

  def showAll(): Unit = {
    println("\ntabla Jugador 1")
    tablePlayer1.showMyTable()
    println("\ntabla Jugador 2")
    tablePlayer2.showMyTable()
    if(weatherZone != null) {
      println(s"\nNombre de Carta Clima: ${weatherZone.name}")
    }else{
      println("\n No hay una carta Clima en el tablero")
    }
  }
  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[GeneralTable]) {
      val other = o.asInstanceOf[GeneralTable]
      (this eq other) ||
        other.tablePlayer1 == tablePlayer1 &&
          other.tablePlayer2 == tablePlayer2 &&
          other.weatherZone == weatherZone
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(tablePlayer1,tablePlayer2)
  }





}
