sealed trait Opcode {
  def params: Map[String, String]
  
  override def toString = getClass.getSimpleName +
  	params.map(_.productIterator.mkString("=")).mkString("(", ",", ")")
}

case class Welcome(val params: Map[String, String]) extends Opcode {
  val name: String = params("name")
  val apocalypse: Int = params("apocalypse").toInt
  val round: Int = params("round").toInt
  val maxslaves: Int = params("maxslaves").toInt
}

case class React(val params: Map[String, String]) extends Opcode {
  val generation: Int = params("generation").toInt
  val name: String = params("name")
  val time: Int = params("time").toInt
  val view: View = View(params("view"))
  val energy: Int = params("energy").toInt  
}

case class GoodBye(val params: Map[String, String]) extends Opcode {
  val energy: Int = params("energy").toInt
}

/*
case class Move extends Opcode
case class Spawn extends Opcode
case class Set extends Opcode
case class Explode extends Opcode

case class Say extends Opcode
case class Status extends Opcode
case class MarkCell extends Opcode
case class DrawLine extends Opcode
case class Log extends Opcode
*/

object Opcode {
  def parse(input: String): (String, Map[String, String]) = {  
    val tokens = input.split('(')
    val opcode = tokens(0)
    val params = tokens(1).dropRight(1)
    	                  .split(',')    	
    	                  .map(_.split('='))
    	                  .map(kv => (kv(0), kv(1)))
    	                  .toMap
    (opcode, params)
  }
  
  def parseServerInput(input: String): Option[Opcode] = {
    val (opcode, params) = parse(input)
    opcode match {
      case "Welcome" => Some(Welcome(params))
      case "React"   => Some(React(params))
      case "GoodBye" => Some(GoodBye(params))
      case _ => None
    }
  }
}
