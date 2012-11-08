trait StupidHarvesting extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    react.view.offsetToNearest(_.isEdible) match {
      case Some(offset)
        => List(Move(offset.signum), Status("Harvesting"))
      case None
        => List(Status("No food in sight"))
    }
  }
}
