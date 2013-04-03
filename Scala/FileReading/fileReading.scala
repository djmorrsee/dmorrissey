def readFileToList(filename:String):List[String] = {

    val fileLines = io.Source.fromFile(filename).getLines.toList;
    fileLines;
}
