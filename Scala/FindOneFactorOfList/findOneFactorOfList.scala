
object findOneFactorOfList {

    def main(args: Array[String]) {
        val startTime = System.currentTimeMillis;
	
	val filename = "list.txt"
	val list = io.Source.fromFile(filename).getLines.toList   
        var i = 0;
        for(a <- list.map(BigInt(_))) {
		
		val st = System.currentTimeMillis
        	var factor:BigInt = 1
		if(a < 3) factor = a
        	else if(a % 2 == 0) factor = 2
        	else factor = findFactor(3:BigInt, a);
		val end = System.currentTimeMillis;
	
        	println(i + ": " + factor + " Time to Find: " + (end - st).toDouble / 1000);
		i = i + 1;
	}
        val endTime = System.currentTimeMillis;

        println("Time to complete: " + ((endTime - startTime).toDouble / 1000).toDouble);
    }


    def argumentErr = { println ("Requires 1 Integer Argument"); System.exit(1) };

    def findFactor (x: BigInt, n: BigInt):BigInt = {
        if (n % x == 0) x
        
        else if (x * x >= n) n
        
        else findFactor(x + 2, n)
    }

}
