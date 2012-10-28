sealed trait ServerOpcode

case class Welcome(
    val name: String,
	val apocalypse: Int,
	val round: Int,
    val maxslaves: Int) 
    extends ServerOpcode

case class React(
    val generation: Int,
	val name: String,
	val time: Int,
	val view: String,
    val energy: Int)
	extends ServerOpcode

case class GoodBye(
    val energy: Int)
    extends ServerOpcode

object ServerOpcode {
  def parse(input: String): Option[ServerOpcode] = {
    def parseWelcome(params: Map[String, String]): Option[Welcome] = {
      for {
        name <- params.get("name")
        apocalypse <- params.get("apocalypse")
        round <- params.get("round")
        maxslaves <- params.get("maxslaves")
      } yield Welcome(name, apocalypse.toInt, round.toInt, maxslaves.toInt)
    }
    
    def parseReact(params: Map[String, String]): Option[React] = {
      for {
        generation <- params.get("generation")
        name <- params.get("name")
        time <- params.get("time")
        view <- params.get("view")
        energy <- params.get("energy")
      } yield React(generation.toInt, name, time.toInt, view, energy.toInt)
    }
    
    def parseGoodBye(params: Map[String, String]): Option[GoodBye] = {
      for {
        energy <- params.get("energy")
      } yield GoodBye(energy.toInt)
    }
    
    val tokens = input.split('(')
    val opcode = tokens(0)
    val params = tokens(1)
    	.dropRight(1)
    	.split(',')    	
    	.map(_.split('='))
    	.map(kv => (kv(0), kv(1)))
    	.toMap
    
    opcode match {
      case "Welcome" => parseWelcome(params)
      case "React"   => parseReact(params)
      case "GoodBye" => parseGoodBye(params)
      case _ => throw new IllegalStateException(
          "ServerOpcode.parse input: " + input)
    }
  }
}
