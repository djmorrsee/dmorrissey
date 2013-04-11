import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask
import akka.event.Logging
import akka.util.Timeout
//import akka.dispatch.await


object FactorActor {
case class Factor(iterator:BigInt, number:BigInt)
case class FinalFactor(iterator:BigInt, number:BigInt)
case object Done
class Factorer extends Actor {
	def receive = { 
               case Factor(i, n) => {
			val st = System.currentTimeMillis;
			val fac = findFactor(3, n) 
			println(i + ": " + fac.toString + " Time to find: " + ((System.currentTimeMillis - st).toDouble / 1000)); 
			//self ! Done
		}
		case FinalFactor(i, n) => {  
			val st = System.currentTimeMillis;
                        val fac = findFactor(3, n)
                        println(i + ": " + fac.toString + " Time to find: " + ((System.currentTimeMillis - st).toDouble / 1000));                      
                        self ! Done
		}	
		case _ => context.system.shutdown
        } 
}

def main(args:Array[String]) {
	val system = ActorSystem("FactorSystem");
	val factorer = system.actorOf(Props[Factorer], name = "factorer")
	
	val startTime = System.currentTimeMillis
	val list = io.Source.fromFile("list.txt").getLines.toList;
	val listLength = list.length
	for(i <- 0 to listLength - 1) {	
		if(i == list.length - 1) factorer ! FinalFactor(i, BigInt(list(i)))		
		else factorer ! Factor(i, BigInt(list(i)));
	}
	println("Time to complete: " + (System.currentTimeMillis - startTime).toDouble / 1000)
	//factorer ! Done
	//system.shutdown();	
}

def findFactor (x: BigInt, n: BigInt):BigInt = {
        if (n % x == 0) x

        else if (x * x >= n) n

        else findFactor(x + 2, n)
}
}
