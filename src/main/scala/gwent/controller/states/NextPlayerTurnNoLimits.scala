package cl.uchile.dcc
package gwent.controller.states
import gwent.controller.{Controller, State}
class NextPlayerTurnNoLimits extends State{
  override def nextTurn(controller: Controller): Unit = this.changeState(controller, new WaitingActionWithPass())
  override def isNextPlayerTurnNoLimits(): Boolean = true
}
