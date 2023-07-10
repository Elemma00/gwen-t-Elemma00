package cl.uchile.dcc
package gwent.model.table

import gwent.controller.Controller
import gwent.model.cards.ICard
import gwent.model.cards.weathercards.AbstractWeatherCard
import gwent.model.player.Players
import gwent.model.table.PlayerTable

import java.util.Objects
import scala.collection.mutable.ArrayBuffer


class GeneralTable(val tablePlayer1: PlayerTable, val tablePlayer2: PlayerTable) {

  var asociatedPlayer1: Players = _
  var asociatedPlayer2: Players = _

  def setPlayers(player1: Players, player2: Players): Unit = {
    asociatedPlayer1 = player1
    asociatedPlayer2 = player2
  }


  //Campo común de cartas de clima
  var weatherZone: AbstractWeatherCard = _

  //variable que contiene al observador del controlador
  var controller: Controller = _

  def registerControllerObserver(control: Controller): Unit = {
    controller = control
  }

  def notifyControllerObserver(): Unit = {
    controller.update(this)
  }

  def setWeatherCard(card: AbstractWeatherCard): Unit = {
    weatherZone = card
  }


  def gameOverCheck(): Unit = {
    if (endGameChecker()) {
      controller.placeWinner()
      println("GAME OVER, thanks for playing :) ")
      notifyControllerObserver()
    }
  }

  def roundWinner(): Unit = {
    controller.endRoundPhase()

    if (tablePlayer1.calculateTotalStrength() > tablePlayer2.calculateTotalStrength()) {
      asociatedPlayer2.receiveDamage()
      gameOverCheck()
      notifyControllerObserver()

    } else if (tablePlayer1.calculateTotalStrength() == tablePlayer2.calculateTotalStrength()) {
      notifyControllerObserver()

    } else {
      asociatedPlayer1.receiveDamage()
      gameOverCheck()
      notifyControllerObserver()
    }

  }

  def endGameChecker(): Boolean = {
    if (tablePlayer1.checkingGemsPlayer(asociatedPlayer1) == false ||
      tablePlayer2.checkingGemsPlayer(asociatedPlayer2) == false) {
      true
    } else {
      false
    }
  }

  def showAll(): Unit = {
    println("\ntabla Jugador 1")
    tablePlayer1.showMyTable()
    println("\ntabla Jugador 2")
    tablePlayer2.showMyTable()
    if (weatherZone != null) {
      println(s"\nNombre de Carta Clima: ${weatherZone.name}")
    } else {
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
    Objects.hash(tablePlayer1, tablePlayer2)
  }

}
