package cl.uchile.dcc
package test
import gwent.controller.Controller
class ControllerTest extends munit.FunSuite {

  var controller: Controller = _
  override def beforeEach(context: BeforeEach): Unit = {
     controller = new Controller()
  }

  test("Start Game State"){
    assert(controller.isStartGame())
    controller.setPlayersAndTable()
    assert(!controller.isStartGame())
  }
  test("Choosing First Player State"){
    assert(!controller.isChoosingFirstPlayer())
    controller.setPlayersAndTable()
    assert(controller.isChoosingFirstPlayer())
  }

  test("First Round State"){
    assert(!controller.isFirstRound())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    assert(controller.isFirstRound())
  }

  test("Waiting Action State"){
    assert(!controller.isWaitingAction())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    assert(controller.isWaitingAction())
  }

  test("Turns Handler State with Play Card Transition"){
    assert(!controller.isTurnsHandler())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.playCard()
    assert(controller.isTurnsHandler())
  }

  test("Turns Handler State with Pass Transition"){
    assert(!controller.isTurnsHandler())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.pass()
    assert(controller.isTurnsHandler())
  }

  test("Next player Turn State"){
    assert(!controller.isNextPlayerTurn())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.playCard()
    controller.changePlayer()
    assert(controller.isNextPlayerTurn())
  }

  test("waiting action after the first turn"){
    assert(!controller.isWaitingAction())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.playCard()
    controller.changePlayer()
    controller.nextTurn()
    assert(controller.isWaitingAction())
  }


  test("Next player Turn State No Limits State"){
    assert(!controller.isNextPlayerTurnNoLimits())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.pass()
    controller.hasPassed()
    assert(controller.isNextPlayerTurnNoLimits())
  }

  test("Waiting action after previous player has passed"){
    assert(!controller.isWaitingActionWithPass())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.pass()
    controller.hasPassed()
    controller.nextTurn()
    assert(controller.isWaitingActionWithPass())
  }

  test("verify that there are no limits to place cards"){
    assert(!controller.isWaitingActionWithPass())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.pass()
    controller.hasPassed()
    controller.nextTurn()
    controller.playCard()
    assert(controller.isWaitingActionWithPass())
  }

  test("The player has no more cards to place or has passed in the Waiting Action no limits State"){
    assert(!controller.isTurnsHandler())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.pass()
    controller.hasPassed()
    controller.nextTurn()
    controller.pass()
    assert(controller.isTurnsHandler())
  }


  test("End Round State"){
    assert(!controller.isRoundDecision())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.pass()
    controller.hasPassed()
    controller.nextTurn()
    controller.pass()
    controller.endRound()
    assert(controller.isRoundDecision())
  }

  test("Start Round State"){
    assert(!controller.isStartRound())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.pass()
    controller.hasPassed()
    controller.nextTurn()
    controller.pass()
    controller.endRound()
    controller.nextRound()
    assert(controller.isStartRound())
  }

  test("End Game State"){
    assert(!controller.isEndGame())
    controller.setPlayersAndTable()
    controller.chooseFirstPlayer()
    controller.setHands()
    controller.pass()
    controller.hasPassed()
    controller.nextTurn()
    controller.pass()
    controller.endRound()
    controller.winner()
    assert(controller.isEndGame())
  }

  test("test Wrong State") {
    interceptMessage[AssertionError]("Estado Equivocado") {
      controller.drawCards()
    }
  }


}
