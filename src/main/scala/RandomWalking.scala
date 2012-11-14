import scala.util.Random

trait RandomWalking extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    val res = List(Move(Vec(randCoord, randCoord)), Status("Random Walking"))
    super.respondToReact(react) ++ res
  }

  private def randCoord = Random.nextInt(4) - 2
}
