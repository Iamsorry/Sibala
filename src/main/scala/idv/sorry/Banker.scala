package idv.sorry

import akka.actor.{ Actor, ActorRef }

class Banker(val name: String) extends Actor {
	var dice = new scala.util.Random

	def receive: Actor.Receive = {
		case Rolled(customerName, playerPoint) =>
			val bankerPoint = dice.nextInt(13)
			println(s"${name}:[${bankerPoint}] vs. ${customerName}:[${playerPoint}]")
			if (playerPoint > bankerPoint)
				sender ! Sausage
	}
}