package cl.uchile.dcc
package gwent.controller.states
import gwent.controller.{Controller, State}
class WaitingActionWithPass extends State{
  override def playCard(controller: Controller): Unit = this.changeState(controller, new WaitingActionWithPass())
  override def pass(controller: Controller): Unit = this.changeState(controller, new TurnsHandler())
  override def isWaitingActionWithPass(): Boolean = true
}
