class ControlFunctionFactory {
  def create = new ControlFunction().respond _
}

class ControlFunction extends InputDispatching




/*
case class ViewOld(cells: String) {
    val size = math.sqrt(cells.length).toInt
    val center = XY(size/2, size/2)

    def offsetToNearest(c: Char) = {
        val relativePositions =
            cells
            .view
            .zipWithIndex
            .filter(_._1 == c)
            .map(p => relPosFromIndex(p._2))
        if(relativePositions.isEmpty)
            None
        else
            Some(relativePositions.minBy(_.length))
    }



    def respond(input: String): String = {
        val (opcode, paramMap) = CommandParser(input)
        if( opcode == "React" ) {
            val viewString = paramMap("view")
            val view = ViewOld(viewString)
            view.offsetToNearest('P') match {
                case Some(offset) =>
                    val unitOffset = offset.signum
                    "Move(direction=" + unitOffset + ")|Status(text=Harvesting)"
                case None =>
                    "Status(text=No Food Visible)"
            }
        } else ""
    }

*/
