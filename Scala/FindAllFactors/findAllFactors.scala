object findOneFactor {

def main(args: Array[String]) {
	args.length match {
		case 1 => println("Finding factor of ", args(0));
		case _ => argumentErr;
	}
	
	val n:BigInt = BigInt(args(0));
	var factors:List[BigInt] = List(1);
	
	
	if(n < 3) factors::List(n);
	else if(n % 2 == 0) factors::List(2);
	else factors::findFactors(3:BigInt, n);
	
	println(factors)
}


def argumentErr = { println ("Requires 1 Integer Argument"); System.exit(1) };

def findFactors(x: BigInt, n: BigInt):List[BigInt] = {
  
	var list:List[BigInt] = List(1);
	list = list ++ List(2:BigInt)
  
	if(a * a > n) List(n);
	else if(n % a == 0) List(a);
	loop(a + 2)
	
	list::List(loop(x));
  
}


}