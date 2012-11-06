trait InputDispatching {
  def respond(input: String): String = {
    val opcodes = Opcode.parseServerInput(input) match {
      case Some(w: Welcome) => respondToWelcome(w)
      case Some(r: React)   => respondToReact(r)
      case Some(g: GoodBye) => respondToGoodBye(g)
      case _ => Nil
    }
    opcodes.mkString("|")
  }

  def respondToWelcome(welcome: Welcome): List[PluginOpcode] = Nil
  def respondToReact(react: React): List[PluginOpcode] = Nil
  def respondToGoodBye(goodbye: GoodBye): List[PluginOpcode] = Nil
}
