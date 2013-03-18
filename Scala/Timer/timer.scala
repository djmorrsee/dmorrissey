object Timer {

def timeThis(f: => Unit):Double = {
	val s:Double = System.currentTimeMillis;
	f;
	System.currentTimeMillis - s;
}

}
