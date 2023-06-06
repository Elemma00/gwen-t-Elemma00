package cl.uchile.dcc
package gwent.controller.states
import gwent.controller.{Controller, State}
class RoundDecision extends State {
  override def winner(controller: Controller): Unit = this.changeState(controller, new EndGame())
  override def nextRound(controller: Controller): Unit = this.changeState(controller, new StartRound())
  override def isRoundDecision(): Boolean = true
}
