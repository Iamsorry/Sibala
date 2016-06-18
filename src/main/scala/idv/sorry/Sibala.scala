package idv.sorry

import akka.actor.{ Actor, ActorRef, ActorSystem, Props }

object Sibala {
	def main(args: Array[String]) {

		println("Sibala!")

		val bicycle = ActorSystem("Sibala")
		val banker = bicycle.actorOf(Props(classOf[Banker], "abeh"))
		val players = new Array[ActorRef](10)

		for (i <- 0 to 9) {
			players(i) = bicycle.actorOf(Props(classOf[Player], s"adia${i}"))
		}

		players.foreach(_.tell(Play, banker))

		Thread.sleep(1000 * 4)
		println("Sayonara")
	}
}
