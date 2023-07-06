package cl.uchile.dcc
package gwent.controller

import gwent.controller.State
import gwent.controller.states.StartGame
import gwent.model.table.GeneralTable
class Controller() extends ControllerObserver {

  var endRoundTurnDecisionHandler = false
  var playerhaspassed = false
  var playerPlayAnotherCardNoLimits = false
  var hasWinner = false

  private var state: State = new StartGame()
  def setState(aState: State): Unit = {
    state = aState
  }

  override def update(generalTable: GeneralTable): Unit = {
    if (isStartGame()) {
      setPlayersAndTable()

    } else if (isChoosingFirstPlayer()) {
      chooseFirstPlayer()

    } else if (isFirstRound()) {
      setHands()

    } else if (isWaitingAction()) {
      if (playerhaspassed) {
        pass()
      } else {
        playCard()
      }

    } else if (isTurnsHandler()) {

      if (endRoundTurnDecisionHandler) {
        endRound()
      } else if (playerhaspassed) {
        hasPassed()
      } else {
        changePlayer()
      }

    } else if (isNextPlayerTurnNoLimits()) {
      nextTurn()

    } else if (isWaitingActionWithPass()) {

      if (playerPlayAnotherCardNoLimits) {
        playerPlayAnotherCardNoLimits = false
        playCard()
      } else {
        pass()
      }

    } else if (isNextPlayerTurn()) {
      playerhaspassed = false
      playerPlayAnotherCardNoLimits = false
      nextTurn()

    } else if (isRoundDecision()) {
      if (hasWinner) {
        winner()
      } else {
        nextRound()
      }

    } else if (isStartRound()) {
      playerhaspassed = false
      playerPlayAnotherCardNoLimits = false
      endRoundTurnDecisionHandler = false
      drawCards()
      
    }else if(isEndGame()){
      println("GAME OVER, thanks for playing :) ")
    }
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

  def endRoundPhase(): Unit = endRoundTurnDecisionHandler = true
  def playerHasPassed():Unit =  playerhaspassed = true
  def playedOneMoreCard():Unit =  playerPlayAnotherCardNoLimits = true

  def placeWinner():Unit = hasWinner = true

}
