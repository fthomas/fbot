case class Pos(x: Int, y: Int) {
  def +(vec: Vec): Pos = Pos(x + vec.x, y + vec.y)
  def -(vec: Vec): Pos = Pos(x - vec.x, y - vec.y)

  def +(that: Pos): Vec = Vec(x + that.x, y + that.y)
  def -(that: Pos): Vec = Vec(x - that.x, y - that.y)

  def l1Dist(other: Pos): Int = (this - other).l1Length
  def l2Dist(other: Pos): Double = (this - other).l2Length
  def lInfDist(other: Pos): Int = (this - other).lInfLength
  
  def toVec = Vec(x, y)
}

object Pos {
  def apply(str: String): Pos = Vec(str).toPos
}
