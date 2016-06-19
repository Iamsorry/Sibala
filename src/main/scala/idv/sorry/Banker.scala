package idv.sorry

import akka.actor.{ Actor, ActorRef }

class Banker(val name: String) extends Actor {
	def receive: Actor.Receive = {

		case Compete(playerName, playerPoint) =>
			val bankerPoint = Dice.Roll()
			println(s"$name:[$bankerPoint] vs. $playerName:[$playerPoint]")
			if (playerPoint > bankerPoint)
				sender ! Sausage

	}
}