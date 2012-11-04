case class Vector(x: Int, y: Int) {
  override def toString = x + ":" + y
  
  def +(that: Vector): Vector = Vector(x + that.x, y + that.y)
  def -(that: Vector): Vector = Vector(x - that.x, y - that.y)

  def addedToX(addend: Int) = Vector(x + addend, y)
  def addedToY(addend: Int) = Vector(x, y + addend)
  
  def updatedX(newX: Int) = Vector(newX, y)
  def updatedY(newY: Int) = Vector(x, newY)
  
  def unary_- = Vector(-x, -y)
  def negateX = Vector(-x,  y)
  def negateY = Vector( x, -y)

  def map(f: Double => Double): Vector = Vector(f(x).toInt, f(y).toInt)
  def *(n: Double): Vector = map(_ * n)
  def /(n: Double): Vector = map(_ / n)

  def max: Int = math.max(x, y)
  def min: Int = math.min(x, y)
  def sum: Int = x + y
  
  def signum: Vector = Vector(x.signum, y.signum)

  def isZero: Boolean = x == 0 && y == 0
  def isNonZero: Boolean = x != 0 || y != 0 
  
  def l1Length: Int = map(_.abs).sum
  def l2Length: Double = math.sqrt(x*x + y*y)
  def lInfLength: Int = map(_.abs).max
}

object Vector {
  def apply(str: String): Vector = {
    val coordinates = str.split(':').map(_.toInt)
    Vector(coordinates(0), coordinates(1))
  }
    
  val up    = Vector( 0,  1)
  val down  = Vector( 0, -1)  
  val right = Vector( 1,  0)
  val left  = Vector(-1,  0)

  val upRight   = Vector( 1,  1)
  val upLeft    = Vector(-1,  1)
  val downRight = Vector( 1, -1)
  val downLeft  = Vector(-1, -1)
}
