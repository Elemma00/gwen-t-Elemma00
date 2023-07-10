package cl.uchile.dcc
package gwent.controller.states
import gwent.controller.{Controller, State}

class StartRound extends State{
  override def drawCards(controller: Controller): Unit = this.changeState(controller, new WaitingAction())

  override def isStartRound(): Boolean = true
}
