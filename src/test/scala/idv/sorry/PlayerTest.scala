package idv.sorry

import org.scalatest.{ Matchers, WordSpecLike }
import akka.actor.{ ActorSystem, Props, actorRef2Scala }
import akka.testkit.{ TestKit, ImplicitSender, DefaultTimeout }

class PlayerTest extends TestKit(ActorSystem("testBicycle"))
	with DefaultTimeout
	with ImplicitSender
	with WordSpecLike
	with Matchers { 

	val bankerRef = system.actorOf(Props(classOf[Banker], "mockAbeh"))
	val playerRef = system.actorOf(Props(classOf[Player], "mockAdia", bankerRef))

	"A player" should {

		"say oishi when eating sausage" in {
			playerRef ! Sausage
		}

	}
}