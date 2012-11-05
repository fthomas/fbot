sealed abstract class Item(val repr: Char) {
  def terrain: Char = repr
}

object Item {
  val allItems = List(Wall, OccludedCell, EmptyCell) ++ Entity.allEntities
  
  private val allItemsMap =
    allItems map (item => item.repr -> item) toMap
  
  def from(repr: Char): Option[Item] = allItemsMap get repr
}

case object Wall         extends Item('W')
case object OccludedCell extends Item('?')
case object EmptyCell    extends Item('_')

sealed abstract class Entity(repr: Char) extends Item(repr) {
  override val terrain: Char = '_'

  val isEdible: Boolean = false
  val isFriendly: Boolean
  def isHostile: Boolean = !isFriendly
}

object Entity {
  val allEntities = List(Master, Slave, EnemyMaster, EnemySlave,
		  				 Zugar,	Toxifera, Fluppet, Snorg)
                         
  private val allEntitiesMap =
    allEntities map (entity => entity.repr -> entity) toMap
    
  def from(repr: Char): Option[Entity] = allEntitiesMap get repr
                         
  val edibleEntities   = allEntities filter (_.isEdible)
  val friendlyEntities = allEntities filter (_.isFriendly)
  val hostileEntities  = allEntities filter (_.isHostile)
}

case object Master extends Entity('M') {
  override val isFriendly = true
}

case object Slave extends Entity('S') {
  override val isFriendly = true
}

case object EnemyMaster extends Entity('m') {
  override val isFriendly = false
}

case object EnemySlave extends Entity('s') {
  override val isFriendly = false
}

case object Zugar extends Entity('P') {
  override val isFriendly = true
  override val isEdible = true
}

case object Fluppet extends Entity('B') {
  override val isFriendly = true
  override val isEdible = true
}

case object Toxifera extends Entity('p') {
  override val isFriendly = false
}

case object Snorg extends Entity('b') {
  override val isFriendly = false
}
