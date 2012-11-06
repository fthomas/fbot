sealed trait Opcode {
  def params: Map[String, String]

  override def toString = getClass.getSimpleName +
    params.map(_.productIterator.mkString("=")).mkString("(", ",", ")")
}

sealed trait ServerOpcode extends Opcode
sealed trait PluginOpcode extends Opcode

case class Welcome(params: Map[String, String]) extends ServerOpcode {
  val name: String = params("name")
  val apocalypse: Int = params("apocalypse").toInt
  val round: Int = params("round").toInt
  val maxslaves: Int = params("maxslaves").toInt
}

case class React(params: Map[String, String]) extends ServerOpcode {
  val generation: Int = params("generation").toInt
  val name: String = params("name")
  val time: Int = params("time").toInt
  val view: View = View(params("view"))
  val energy: Int = params("energy").toInt
}

case class GoodBye(params: Map[String, String]) extends ServerOpcode {
  val energy: Int = params("energy").toInt
}

case class Move(direction: Vec) extends PluginOpcode {
  val params = Map("direction" -> direction.toString)
}

case class Spawn (params: Map[String, String]) extends PluginOpcode {
  //
}

case class Set(params: Map[String, String]) extends PluginOpcode {
  require(!params.isEmpty)
}

case class Explode(size: Int) extends PluginOpcode {
  val params = Map("size" -> size.toString)
}

case class Say(text: String) extends PluginOpcode {
  val params = Map("text" -> text)
}

case class Status(text: String) extends PluginOpcode {
  val params = Map("text" -> text)
}

case class MarkCell(position: Pos, color: String) extends PluginOpcode {
  val params = Map("position" -> position.toString, "color" -> color)
}

case class DrawLine(from: Pos, to: Pos, color: String) extends PluginOpcode {
  val params = Map("from" -> from.toString,
                   "to" -> to.toString,
                   "color" -> color)
}

case class Log(text: String) extends PluginOpcode {
  val params = Map("text" -> text)
}

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

  def parseServerInput(input: String): Option[ServerOpcode] = {
    val (opcode, params) = parse(input)
    opcode match {
      case "Welcome" => Some(Welcome(params))
      case "React"   => Some(React(params))
      case "GoodBye" => Some(GoodBye(params))
      case _ => None
    }
  }
}
