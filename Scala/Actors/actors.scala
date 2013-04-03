import scala.actors.Actor
import scala.actors.Actor._

object actors {

	case class Factor(number: Int)
	case object Done
	
	object Factorer extends Actor {
		def act = {
			while(true) {
				receive {
					case Factor(n) => println (n)
					case Done => exit
				}
			}
		}
	}

	def main(args:Array[String]):Unit = {
		Factorer.start
		for(a <- 3 to 100) {
			(Factorer ! Factor(a))
			
		}
		Factorer ! Done
		
		exit
	}

	def make_actors = {
		
	}
	
	
	def findFactor (x: BigInt, n: BigInt):BigInt = {
        if (n % x == 0) x
        
        else if (x * x >= n) n
        
        else findFactor(x + 2, n)
    }
}
