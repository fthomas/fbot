class ControlFunctionFactory {
  def create = new ControlFunction().respond _
}

class ControlFunction extends InputDispatching
  with StupidHarvesting
