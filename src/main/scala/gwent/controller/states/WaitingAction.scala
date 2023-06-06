package cl.uchile.dcc
package gwent.controller.states
import gwent.controller.{Controller, State}

class WaitingAction extends State {

  override def playCard(controller: Controller): Unit = this.changeState(controller, new TurnsHandler())
  override def pass(controller: Controller): Unit = this.changeState(controller, new TurnsHandler())

  override def isWaitingAction(): Boolean = true
}
