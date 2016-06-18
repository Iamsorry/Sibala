package idv.sorry

import akka.actor.{ Actor, ActorRef }

class Player(val name: String, val banker: ActorRef) extends Actor {
	val dice = new scala.util.Random

	def receive: Actor.Receive = {

		case Play =>
			val playerPoint = rollDice()
			println(s"$name gets $playerPoint")
			banker ! Compete(name, playerPoint)

		case Sausage =>
			println(s"${name}: oishi!")

	}
	
	private def rollDice() = dice.nextInt(10) + 3
}