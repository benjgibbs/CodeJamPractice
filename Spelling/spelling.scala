
import scala.io.Source

val file = "C-large-practice"
val in = file+".in"
val out = file+".out"

val outFile = new java.io.FileWriter(out)

def output(outline: String) = {
  println(outline)
  outFile.write(outline+"\n")
}

def generateKeys(c: Char,b: Char, bk: Int, n: Int) = {
    val pos = c.toInt - b.toInt
    val key = bk + pos/n 
    val numPress = 1 + (pos % n)
    Range(0,numPress).map(_=>key).mkString
}

def toSequence(c: Char) : String = {
  if (c == ' ')
    "0"
  else if (c.toInt < 'p'.toInt) 
    generateKeys(c,'a',2,3)
  else if(c.toInt < 't'.toInt)
    generateKeys(c,'p',7,4)
  else if(c.toInt < 'w'.toInt)
    generateKeys(c,'t',8,3)
  else
    generateKeys(c,'w',9,4)
}


var count = 1
for (line <- Source.fromFile(in).getLines().drop(1)) {
  var lastKey = -1
  var builder = new StringBuilder()
  for(c <- line.toList) {
    val seq = toSequence(c)
    if(seq(0) == lastKey)
      builder.append(' ')
    builder.append(seq)
    lastKey = seq(0);
  }
  output("Case #"+count +": " + builder.toString )
  count += 1
}

outFile.close()

