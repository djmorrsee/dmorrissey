object multithread {

	def main (args:Array[String]) {

		println("Multithread");
		multithread();
		println("Singlethread");
		singlethread();
		
	}

	def multithread () {
		var time = System.currentTimeMillis;		
		var file = io.Source.fromFile("list.txt").getLines.toList.par; 		
		println("Multi Thread Time Taken: " + (System.currentTimeMillis - time));
	}

	def singlethread () {
		var time = System.currentTimeMillis;
		var file = io.Source.fromFile("list.txt").getLines.toList;

		file.map(apply(_));					
		println("Single Thread Time Taken: " + (System.currentTimeMillis - time));
	}
	
	def apply (x:String) {
		println(x.toInt + 2);
	}
}
