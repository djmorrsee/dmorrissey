object EconExperiment {
def getScore (clothes:Int, food:Int, housing:Int):Double =  {
	assert(clothes + 2 * food + 3 * housing <= 100);
	10 * Math.sqrt(clothes) + 10 * Math.sqrt(food) + 10 * Math.sqrt(housing) + (100 - clothes - 2*food - 3*housing);
 }

def findSolution ( ):(Int, Int, Int) = {
	var score:Double = 0;
	var x = 0; var y = 0; var z = 0;
	for(h <- 0 to 33) {
		for(i <- 0 to 50) {
			for(j <- 0 to 100) {
				if (h * 3 + i * 2 + j <= 100) {
					val temp = getScore(j, i, h);
					if(temp > score) {
						score = temp;
						x = j; y = i; z = h;
					}
				}		
			}
		}
	}
	(x, y, z); 



	
}


def main(args: Array[String]) {
var [A, B, C] = findSolution();
println("Hello");
}
}
