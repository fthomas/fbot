case class View(cells: String) {
  val size: Int = math.sqrt(cells.length).toInt

  lazy val entities =
    for (cell <- cells; entity <- Entity.from(cell)) yield entity
  lazy val offsets =
    entities.zipWithIndex.map(x => relPosFromIndex(x._2).toVec -> x._1)

  def apply(rel: Pos) = cells(indexFromRelPos(rel))

  def offsetsToBy[B](pred: Entity => Boolean, sortFun: ((Vec, Entity)) => B)
                    (implicit ord: Ordering[B]) = {
    offsets.filter(x => pred(x._2)).sortBy(sortFun)
  }

  def offsetToNearest(pred: Entity => Boolean): Option[Vec] = {
    offsetsToBy(pred, _._1.lInfLength).headOption.map(_._1)
  }

  def offsetToNearest(entity: Entity): Option[Vec] =
    offsetToNearest(_ == entity)

  def offsetToFarthest(pred: Entity => Boolean): Option[Vec] = {
    offsetsToBy(pred, _._1.lInfLength).lastOption.map(_._1)
  }

  def offsetToFarthest(entity: Entity): Option[Vec] =
    offsetToFarthest(_ == entity)

  def terrain = View(entities map (_.terrain) toString)

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
