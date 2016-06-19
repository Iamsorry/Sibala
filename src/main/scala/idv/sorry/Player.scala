package idv.sorry

import akka.actor.{ Actor, ActorRef }

class Player(val name: String, val banker: ActorRef) extends Actor {
	def receive: Actor.Receive = {

		case Play =>
			val playerPoint = Dice.Roll()
			println(s"$name gets $playerPoint")
			banker ! Compete(name, playerPoint)

		case Sausage =>
			println(s"${name}: oishi!")

	}
}