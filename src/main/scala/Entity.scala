sealed abstract class Entity(val repr: Char) {
  val terrain: Char = '_'

  val isEdible: Boolean = false
  val isFriendly: Boolean = true
  val isHostile: Boolean = !isFriendly
}

sealed abstract class Lifeless(repr: Char) extends Entity(repr) {
  override val terrain = repr
}

case object EmptyCell extends Lifeless('_')

case object OccludedCell extends Lifeless('?')

case object Wall extends Lifeless('W')

case object Master extends Entity('M')

case object Slave extends Entity('S')

case object EnemyMaster extends Entity('m') {
  override val isFriendly = false
}

case object EnemySlave extends Entity('s') {
  override val isFriendly = false
}

case object Zugar extends Entity('P') {
  override val isEdible = true
}

case object Fluppet extends Entity('B') {
  override val isEdible = true
}

case object Toxifera extends Entity('p') {
  override val isFriendly = false
}

case object Snorg extends Entity('b') {
  override val isFriendly = false
}

object Entity {
  val allEntities = List(EmptyCell, OccludedCell, Wall,
                         Master, Slave, EnemyMaster, EnemySlave,
                         Zugar, Toxifera, Fluppet, Snorg)

  private val allEntitiesMap =
    allEntities map (entity => entity.repr -> entity) toMap

  def from(repr: Char): Option[Entity] = allEntitiesMap get repr

  val edibleEntities   = allEntities filter (_.isEdible)
  val friendlyEntities = allEntities filter (_.isFriendly)
  val hostileEntities  = allEntities filter (_.isHostile)
}
