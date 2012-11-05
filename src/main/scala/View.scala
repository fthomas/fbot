case class View(cells: String) {
  val size: Int = math.sqrt(cells.length).toInt
  
  def items = for (cell <- cells; item <- Item.from(cell)) yield item
  def terrain = View(items map (_.terrain) toString)
  
  def apply(rel: Pos) = cells(indexFromRelPos(rel))
  
  private val absCenter = Pos(size / 2, size / 2)
  
  private def relPosFromAbsPos(abs: Pos) = (abs - absCenter).toPos
  private def absPosFromRelPos(rel: Pos) = (rel + absCenter).toPos
  
  private def absPosFromIndex(index: Int) = Pos(index % size, index / size)
  private def indexFromAbsPos(abs: Pos) = abs.x + abs.y * size
  
  private def relPosFromIndex(index: Int) =
    relPosFromAbsPos(absPosFromIndex(index))
  private def indexFromRelPos(rel: Pos) =
    indexFromAbsPos(absPosFromRelPos(rel))
}
