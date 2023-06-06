package cl.uchile.dcc
package gwent.controller.states
import gwent.controller.{Controller, State}
class NextPlayerTurn extends State {
  override def nextTurn(controller: Controller): Unit = this.changeState(controller,new WaitingAction())

  override def isNextPlayerTurn(): Boolean = true
}
