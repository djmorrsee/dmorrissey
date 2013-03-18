object findOneFactor {

    def main(args: Array[String]) {
        val startTime = System.currentTimeMillis;

        args.length match {
            case 1 => println("Finding factor of " + args(0));
            case _ => argumentErr;
        }
        
        val n:BigInt = BigInt(args(0));
        var factor:BigInt = 1;
        
        if(n < 3) factor = n;
        else if(n % 2 == 0) factor = 2;
        else factor = findFactor(3:BigInt, n);
        
        val endTime = System.currentTimeMillis;

        println(factor)

        println("Time to complete: " + ((endTime - startTime).toDouble / 1000).toDouble);
    }


    def argumentErr = { println ("Requires 1 Integer Argument"); System.exit(1) };

    def findFactor (x: BigInt, n: BigInt):BigInt = {
        if (n % x == 0) x
        
        else if (x * x >= n) n
        
        else findFactor(x + 2, n)
    }

}


/// Benchmarks Friday, March 15
// 17 Digit prime number 11 seconds
// 18 Digit prime number 34 seconds
//
