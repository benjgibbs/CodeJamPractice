
import scala.io.Source
import scala.util.Sorting

val file = "test"
val in = file+".in"
val out = file+".out"

val outFile = new java.io.FileWriter(out)

def output(outline: String, count: Long) = {
  val fullLine = "Case #"+count +": "+outline
  println(fullLine)
  outFile.write(fullLine+"\n")
}

var count = 1
var scenario = 1
var N = 0 //number of milkshake flavours
var M = 0 //number of customers
var endCase = 3
var customers = List[Array[Int]]()
for (line <- Source.fromFile(in).getLines().drop(1)) {
  println("Line: " + line)
  if(count==1){
    println("1: N="+N+",M="+M+",count="+count)
    N = line.toInt
  }
  else if(count==2){
    println("2: N="+N+",M="+M+",count="+count)
    M = line.toInt
    endCase = 2+M
  }
  else if(count==endCase){
    println("0: N="+N+",M="+M+",count="+count)
    
    customers = customers.sort(_.length<_.length)
    val flavours = new Array(N)
    for(c <- customers){
      
    }

    output("",scenario)
    scenario += 1
    count=0
    customers = List[Array[Int]]
  }
  else{
    println("X: N="+N+",M="+M+",count="+count)
    val likes = line.split(' ').drop(1).map(_.toInt)
    customers =  likes :: customers
  }
  count += 1
}

outFile.close()

