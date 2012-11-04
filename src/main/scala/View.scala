
/*
object View {
  val edibleEntities = List('P', 'B')
  val friendlyEntities = List('M', 'S') ++ edibleEntities
  val hostileEntities = friendlyEntities map (_.toLower)
  
  def isFriendly(cell: Char): Boolean = friendlyEntities contains cell
  def isHostile(cell: Char): Boolean = hostileEntities contains cell
  
  def isZugar(cell: Char): Boolean = cell == 'P'
  def isFluppet(cell: Char): Boolean = cell == 'B'
  
  
  
  def isTerrain(cell: Char): Boolean = List('?', '_', 'W') contains cell
  def toTerrain(cell: Char): Char = if (isTerrain(cell)) cell else '_'
  
  def terrain(view: String): String = view map toTerrain
}
*/
