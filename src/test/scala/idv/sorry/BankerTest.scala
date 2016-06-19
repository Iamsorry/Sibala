package idv.sorry

import org.scalatest.{ Matchers, WordSpecLike }
import akka.actor.{ ActorSystem, Props, actorRef2Scala }
import akka.testkit.{ TestKit, ImplicitSender, DefaultTimeout }

class BankerTest extends TestKit(ActorSystem("testBicycle"))
	with DefaultTimeout
	with ImplicitSender
	with WordSpecLike
	with Matchers { 

	val bankerRef = system.actorOf(Props(classOf[Banker], "mockAbeh"))

	"A banker" should {

		"give nothing when losing" in {
			bankerRef ! Compete("mockAdia", 2)
			expectNoMsg
		}

		"give sausage when winning" in {
			bankerRef ! Compete("mockAdia", 13)
			expectMsg(Sausage)
		}

	}
}