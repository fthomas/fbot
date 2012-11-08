case class View(cells: String) {
  val size: Int = math.sqrt(cells.length).toInt

  val entities = for (cell <- cells; entity <- Entity.from(cell)) yield entity
  def terrain = View(entities map (_.terrain) toString)

  def apply(rel: Pos) = cells(indexFromRelPos(rel))

  def offsetToNearest(entity: Entity): Option[Vec] =
    offsetToNearest(_ == entity)

  def offsetToNearest(p: Entity => Boolean): Option[Vec] = {
    val relativePositions =
      entities.view
              .zipWithIndex
              .filter(x => p(x._1))
              .map(x => relPosFromIndex(x._2).toVec)

    if (relativePositions.isEmpty) None
    else Some(relativePositions.minBy(_.lInfLength))
  }

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
