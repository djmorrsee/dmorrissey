object multithread {

	def main (args:Array[String]) {
		val _preload = io.Source.fromFile("list.txt").getLines.toList
		var singAccu:Double = 0
		var parAccu:Double = 0

		for(i <- 0 to 100) {	
			val singTime = single(_preload);
        	        println("Single Thread Time = " + singTime);
		
			val parTime = parallel(_preload);
			println("Multithread Time = " + parTime);

			singAccu += singTime
			parAccu += parTime
		}
		println("Average Single Thread Time = " + (singAccu / 100).toDouble)	
		println("Average Multi Thread Time = " + (parAccu / 100).toDouble)
	}

	def parallel (x:List[String]):Double = {
		val st = System.currentTimeMillis
		var file = io.Source.fromFile("list.txt").getLines.toList
		var file2 = file.map(apply(_)).par
		(System.currentTimeMillis - st).toDouble
	}

	def single (x:List[String]):Double = {
		val st = System.currentTimeMillis;
		var file = io.Source.fromFile("list.txt").getLines.toList
		var file2:List[BigInt] = file.map(apply(_))
		(System.currentTimeMillis - st).toDouble
	}

	
	def apply (x:String):BigInt = {
		BigInt(x)
	}
}
