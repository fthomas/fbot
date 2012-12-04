import scala.util.Random

trait RandomSpawning extends NoopResponding {
  override def respondToReact(react: React): List[PluginOpcode] = {
    val res = if (Random.nextFloat > 0.75) {
      List(new Spawn(Vec.random()))
    } else {
      Nil
    }
    super.respondToReact(react) ++ res
  }
}
