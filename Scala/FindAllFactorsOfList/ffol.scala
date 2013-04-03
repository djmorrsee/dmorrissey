object findAllFactorsOfList {
	
	def main(args: Array[String]) {
		val startTime = System.currentTimeMillis;
		find( ) 
		val endTime = System.currentTimeMillis;

        	println("Time to complete: " + ((endTime - startTime).toDouble / 1000).toDouble)
	}

	def find ( ) = {
		val filename = "list.txt";
		val lines = io.Source.fromFile(filename).getLines.toList;
		var i = 0;
		for(a:String <- lines) {
			val st = System.currentTimeMillis;
			println(i + ": " + findFactor(3, BigInt(a)).toString + " Time to find: " + ((System.currentTimeMillis - st).toDouble / 1000));
			i = i + 1;
		}
	}
	def findFactor (x: BigInt, n: BigInt):BigInt = {
       		if (n % x == 0) x
	 	else if (x * x >= n) n
        	else findFactor(x + 2, n)
    	}
}
