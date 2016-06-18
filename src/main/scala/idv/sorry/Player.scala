package idv.sorry

import akka.actor.{ Actor, ActorRef }

class Player(val name: String, val banker: ActorRef) extends Actor {
	var dice = new scala.util.Random

	def receive: Actor.Receive = {
		case Play =>
			val playerPoint = dice.nextInt(13)
			println(s"${name} gets ${playerPoint}")
			banker ! Rolled(name, playerPoint)
		case Sausage =>
			println(s"${name}: oishi!")
	}
}