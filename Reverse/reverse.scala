
import scala.io.Source

val file = "B-small-practice"

val in = file+".in"
val out = file+".out"


val outFile = new java.io.FileWriter(out)

def output(outline: String) = {
  println(outline)
  outFile.write(outline+"\n")
}

var count = 1
for (line <- Source.fromFile(in).getLines().drop(1)) {
  val reversed = line.split(' ').reverse.foldLeft("")(_+' '+_)
  output("Case #"+count +": " + reversed )
  count += 1
}

outFile.close()

