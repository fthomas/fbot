/* 
    "?" cell whose content is occluded by a wall
    "_" empty cell
    "W" wall
    "M" Bot (=master; yours, always in the center unless seen by a slave)
    "m" Bot (=master; enemy, not you)
    "S" Mini-bot (=slave, yours)
    "s" Mini-bot (=slave; enemy's, not yours)
    "P" Zugar (=good plant, food)
    "p" Toxifera (=bad plant, poisonous)
    "B" Fluppet (=good beast, food)
    "b" Snorg (=bad beast, predator)
*/

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
