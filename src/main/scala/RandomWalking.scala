import scala.util.Random

trait RandomWalking extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    val randomMove = List(Move(Vec.random()))
    super.respondToReact(react) ++ randomMove
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

// do not walk against walls
// do not walk into toxic things, if there are other possibilities
//