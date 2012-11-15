import scala.util.Random

case class Vec(x: Int, y: Int) {
  def +(that: Vec) = Vec(x + that.x, y + that.y)
  def -(that: Vec) = Vec(x - that.x, y - that.y)

  def addedToX(addend: Int) = Vec(x + addend, y)
  def addedToY(addend: Int) = Vec(x, y + addend)

  def updatedX(newX: Int) = Vec(newX, y)
  def updatedY(newY: Int) = Vec(x, newY)

  def unary_- = Vec(-x, -y)
  def negateX = Vec(-x,  y)
  def negateY = Vec( x, -y)

  def map(f: Double => Double): Vec = Vec(f(x).toInt, f(y).toInt)
  def *(n: Double): Vec = map(_ * n)
  def /(n: Double): Vec = map(_ / n)

  def max: Int = math.max(x, y)
  def min: Int = math.min(x, y)
  def sum: Int = x + y

  def signum: Vec = Vec(x.signum, y.signum)

  def isZero: Boolean = x == 0 && y == 0
  def isNonZero: Boolean = x != 0 || y != 0 

  def l1Length: Int = map(_.abs).sum
  def l2Length: Double = math.sqrt(x*x + y*y)
  def lInfLength: Int = map(_.abs).max

  override def toString = x + ":" + y
  def toPos = Pos(x, y)
}

object Vec {
  def apply(str: String): Vec = {
    val coords = str.split(':').map(_.toInt)
    Vec(coords(0), coords(1))
  }

  def random(dist: Int = 1): Vec = {
    def rnd = Random.nextInt(dist*2 + 1) - dist
    Vec(rnd, rnd)
  }

  val up    = Vec( 0,  1)
  val down  = Vec( 0, -1)
  val right = Vec( 1,  0)
  val left  = Vec(-1,  0)

  val upRight   = Vec( 1,  1)
  val upLeft    = Vec(-1,  1)
  val downRight = Vec( 1, -1)
  val downLeft  = Vec(-1, -1)

  val allDirections =
    List(up, upRight, right, downRight, down, downLeft, left, upLeft)
}
