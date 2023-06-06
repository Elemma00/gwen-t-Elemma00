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

  def changePlayer(): Unit =  state.changePlayer(this)

  def setHands(): Unit = state.setHands(this)

  def playCard(): Unit = state.playCard(this)

  def pass(): Unit = state.pass(this)

  def nextTurn(): Unit = state.nextTurn(this)

  def drawCards(): Unit = state.drawCards(this)

  def hasPassed(): Unit = state.hasPassed(this)

  def nextRound(): Unit = state.nextRound(this)

  def endRound(): Unit = state.endRound(this)

  def winner(): Unit = state.winner(this)


  def isStartGame(): Boolean = state.isStartGame()

  def isChoosingFirstPlayer(): Boolean = state.isChoosingFirstPlayer()

  def isFirstRound(): Boolean = state.isFirstRound()

  def isWaitingAction(): Boolean = state.isWaitingAction()

  def isStartRound(): Boolean = state.isStartRound()

  def isTurnsHandler(): Boolean = state.isTurnsHandler()

  def isNextPlayerTurn(): Boolean = state.isNextPlayerTurn()

  def isNextPlayerTurnNoLimits(): Boolean = state.isNextPlayerTurnNoLimits()

  def isWaitingActionWithPass(): Boolean = state.isWaitingActionWithPass()

  def isRoundDecision(): Boolean = state.isRoundDecision()

  def isEndGame(): Boolean = state.isEndGame()

}
