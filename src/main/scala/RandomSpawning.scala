import scala.util.Random

trait RandomSpawning extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    val res = if (Random.nextFloat > 0.75) {
      List(Spawn(Map("direction" -> Vec.random().toString)))
    } else {
      List()
    }
    super.respondToReact(react) ++ res
  }
}
