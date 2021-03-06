package idv.sorry

import akka.actor.{ Actor, ActorRef, ActorSystem, Props }

object Sibala {
    def main(args: Array[String]) {
        println("Sibala!")

        val casino = ActorSystem("bicycle")
        val banker = casino.actorOf(Props(classOf[Banker], "abeh"))
        var players = List[ActorRef]()

        for (i <- 0 to 9) {
            players = casino.actorOf(Props(classOf[Player], s"adia$i", banker)) :: players
        }

        players.foreach(_ ! Play)

        Thread.sleep(1000 * 4)
        println("Sayonara")
        casino.terminate()
    }
}
