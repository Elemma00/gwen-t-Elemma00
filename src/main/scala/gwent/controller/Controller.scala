package cl.uchile.dcc
package gwent.controller

import gwent.controller.states.StartGame
import gwent.controller.State
class Controller(){

  private var state: State = new StartGame()
  def setState(aState: State): Unit = {
    state = aState
  }

  def error() = throw new AssertionError("Wrong State")

  def setPlayersAndTable(): Unit = state.setPlayersAndTable(this)

  def chooseFirstPlayer(): Unit = state.chooseFirstPlayer(this)

  def setHands(): Unit = state.setHands(this)

  def playCard(): Unit = state.playCard(this)

  def pass(): Unit = state.pass(this)

  def nextTurn(): Unit = state.nextTurn(this)

  def drawCards(): Unit = state.drawCards(this)

  def hasPassed(): Unit = state.hasPassed(this)

  def nextRound(): Unit = state.nextRound(this)

  def endRound(): Unit = state.endRound(this)

  def winner(): Unit = state.winner(this)
}
