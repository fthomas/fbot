trait StupidHarvesting extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    val res = react.view.offsetToNearest(_.isEdible) match {
      case Some(offset) => List(Move(offset.signum))
      case None => Nil
    }
    super.respondToReact(react) ++ res
  }
}

trait NonStunningStupidHarvesting extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    val view = react.view
    val res = view.offsetToNearest(_.isEdible) match {
      case Some(offset) if !view.occupiedBy(offset.signum.toPos, Wall)
        => List(Move(offset.signum))
      case _
        => Nil
    }
    super.respondToReact(react) ++ res
  }
}
