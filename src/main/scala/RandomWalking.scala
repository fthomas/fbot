import scala.util.Random

trait RandomWalking extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    val res = List(Move(Vec.random()))
    super.respondToReact(react) ++ res
  }
}

trait NonStunningRandomWalking extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    val offsets = react.view.freeDirections
    val res = {
      if (offsets.isEmpty) Nil
      else {
        val randOffset = offsets(Random.nextInt(offsets.length))
        List(Move(randOffset))
      }
    }
    super.respondToReact(react) ++ res
  }
}
