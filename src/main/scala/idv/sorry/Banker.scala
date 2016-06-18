package idv.sorry

import akka.actor.{ Actor, ActorRef }

class Banker(val name: String) extends Actor {
	val dice = new scala.util.Random

	def receive: Actor.Receive = {

		case Compete(customerName, playerPoint) =>
			val bankerPoint = rollDice()
			println(s"$name:[$bankerPoint] vs. $customerName:[$playerPoint]")
			if (playerPoint > bankerPoint)
				sender ! Sausage

	}
	
	private def rollDice() = dice.nextInt(10) + 3
}