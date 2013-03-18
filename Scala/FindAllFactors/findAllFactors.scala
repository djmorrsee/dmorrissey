object findAllFactors {

def main(args: Array[String]) {
	args.length match {
		case 1 => println("Finding factors of " + args(0));
		case _ => argumentErr;
	}
	
	val n:BigInt = BigInt(args(0));
	var factors:List[BigInt] = List[BigInt](1);
	
	

	if(n < 3) factors::List(n);
	else factors = findFactors(n);
	
	println(factors)
    println("Total Factors: " + numberOfFactors(factors))
}


def argumentErr = { println ("Requires 1 Integer Argument"); System.exit(1) };

def findFactors(n: BigInt):List[BigInt] = {

	var list:List[BigInt] = List(1);
    def loop (i:BigInt, n:BigInt):List[BigInt] = {
        if(i >= n / 2) { List(n) }
        else if (n % i == 0) {
            i::loop(i + 1, n);
        } else {
            loop(i + 1, n);
        }
    }
    list:::loop(2, n)
}

def numberOfFactors (n: BigInt):Int = {
    findFactors(n).size
}

def numberOfFactors(l: List[BigInt]):Int = {
    l.size
}

}
