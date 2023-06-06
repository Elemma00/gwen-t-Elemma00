package cl.uchile.dcc
package gwent.controller.states
import gwent.controller.{Controller, State}
class TurnsHandler extends State{

  override def changePlayer(controller: Controller): Unit = this.changeState(controller, new NextPlayerTurn())
  override def endRound(controller: Controller): Unit = this.changeState(controller, new RoundDecision())
  override def hasPassed(controller: Controller): Unit = this.changeState(controller, new NextPlayerTurnNoLimits())

  override def isTurnsHandler(): Boolean = true
}
