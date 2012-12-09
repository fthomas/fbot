trait StupidHarvesting extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    val move = react.view.offsetToNearest(_.isEdible).map {
      offset => Move(offset.signum)
    }
    super.respondToReact(react) ++ move
  }
}

trait NonStunningStupidHarvesting extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    val view = react.view
    val move = for {
      offset <- view.offsetToNearest(_.isEdible)
      if !view.occupiedBy(offset.signum.toPos, Wall)
    } yield Move(offset.signum)

    super.respondToReact(react) ++ move
  }
}
