object findAllFactors {

def main(args: Array[String]) {
	args.length match {
		case 1 => println("Finding factor of ", args(0));
		case _ => argumentErr;
	}
	
	val n:BigInt = BigInt(args(0));
	var factors:List[BigInt] = List[BigInt](1);
	
	
	if(n < 3) factors::=n;
	else if(n % 2 == 0) factors::=2:BigInt;
	else factors:::findFactors(3:BigInt, n);
	
	println(factors)
}


def argumentErr = { println ("Requires 1 Integer Argument"); System.exit(1) };

def findFactors(x: BigInt, n: BigInt):List[BigInt] = {
	var list = List[BigInt]()
	var i:BigInt = 3;
	while (i * i < n)
		if(n % i == 0) list::=i

	list
}


}