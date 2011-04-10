
import scala.io.Source
import scala.util.Sorting

val file = "A-large-practice"
val in = file+".in"
val out = file+".out"

val outFile = new java.io.FileWriter(out)

def output(outline: String, count: Long) = {
  val fullLine = "Case #"+count +": "+outline
  println(fullLine)
  outFile.write(fullLine+"\n")
}

def crossProduct(v1: Array[Long], v2: Array[Long]) : Long = {
  var cp : Long  = 0
  for(i <- 0 until v1.length)
    cp += v1(i)*v2(i)
  cp
}

var count = 1
var vector1 = Array[Long]()
for (line <- Source.fromFile(in).getLines().drop(1)) {
  if(count%3==2){
    val temp = line.split(' ').map(_.toLong)
    Sorting.quickSort(temp)
    vector1 = temp.reverse
  }
  else if(count%3==0){
    val vector2  = line.split(' ').map(_.toLong)
    Sorting.quickSort(vector2)
    output(crossProduct(vector1,vector2).toString,count/3)
  }
  count += 1
}

outFile.close()

