object PollardRho {

	def main (args:Array[String]) = {
		assert (args.length == 1)
		val n:BigInt = BigInt(args(0))
		
		val start = System.currentTimeMillis
		println(pRho(n) + " Time Taken: " + (System.currentTimeMillis - start).toDouble/ 1000.toDouble)
	}
	def f(x:BigInt):BigInt = {
		x * x + 1
	}

	def pRho(n:BigInt):BigInt = {

		var x:BigInt = 2
		var y:BigInt = 2
		var d:BigInt = 1
		while(d == 1) {
			x = f(x)
			y = f(f(y))
			d = (x - y).gcd(n)
			//println(d)
		}
		if(d == 0) 0
		else d
	}
}
