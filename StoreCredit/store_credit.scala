import scala.io.Source

var count = 0
var C = 0
val file = "A-large-practice.in"
val out = "out"
val outFile = new java.io.FileWriter(out)

for (line <- Source.fromFile(file).getLines().drop(1)) {
  if (count % 3 == 0)
    C = Integer.parseInt(line)
  else if (count % 3 == 2) {
    val L = line.split(' ').map(x => Integer.parseInt(x))
    for(i <- 0 until L.size-1)
      for(j <- i+1 until L.size)
        if(L(i)+L(j)==C) {
            val outline = "Case #"+(1+count/3) +": " + (i+1) + " " + (j+1) 
            println(outline)
            outFile.write(outline+"\n")
        }
  }
  count += 1
}

outFile.close()




