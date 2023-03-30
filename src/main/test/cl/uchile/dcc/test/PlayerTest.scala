package cl.uchile.dcc
package test

import gwent.model.cards.unitscards.{DistanceUnit, MeleeUnit, SiegeUnit}
import gwent.model.player.Players

import scala.collection.mutable.ListBuffer

class PlayerTest extends munit.FunSuite {

  var player1: Players = _
  var player2: Players = _
  var player3: Players = _
  var Siegue1: SiegeUnit = _
  var Siegue2: SiegeUnit = _
  var Siegue3: SiegeUnit = _
  var Distance1: DistanceUnit = _
  var Distance2: DistanceUnit = _
  var Distance3: DistanceUnit = _
  var Melee1: MeleeUnit = _
  var Melee2: MeleeUnit = _
  var Melee3: MeleeUnit = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new Players("nombrexd", 2)
    player2 = new Players("player2", 2)
    player3 = new Players("player2", 2)

    Siegue1 = new SiegeUnit("siegue1", 5)
    Siegue2 = new SiegeUnit("siegue2", 5)
    Siegue3 = new SiegeUnit("siegue2", 5)

    Distance1 = new DistanceUnit("Distance1", 3)
    Distance2 = new DistanceUnit("Distance2", 6)
    Distance3 = new DistanceUnit("Distance2", 6)

    Melee1 = new MeleeUnit("Melee1", 8)
    Melee2 = new MeleeUnit("Melee2", 5)
    Melee3 = new MeleeUnit("Melee2", 5)


    test("equal player addresses") {
      assertEquals(player2, player2)
    }

    test("equal player values") {
      player2.equals(player3)
    }

    test("not equal player values") {
      player2.equals(player1)
    }

    test("equal SiegueUnit addresses") {
      assertEquals(Siegue1, Siegue1)
    }

    test("equal SiegueUnit values") {
      Siegue2.equals(Siegue3)
    }

    test("not equal SiegueUnit values") {
      Siegue1.equals(Siegue3)
    }

    test("equal DistanceUnit addresses") {
      assertEquals(Distance1, Distance1)
    }

    test("equal DistanceUnit values") {
      Distance2.equals(Distance3)
    }

    test("not equal DistanceUnit values") {
      Distance1.equals(Distance3)
    }

    test("equal MeleeUnit addresses") {
      assertEquals(Melee1, Melee1)
    }

    test("equal MeleeUnit values") {
      Melee2.equals(Melee3)
    }

    test("not equal MeleeUnit values") {
      Melee1.equals(Melee3)
    }


  }


}
