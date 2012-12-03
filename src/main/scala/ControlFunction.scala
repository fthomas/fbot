class ControlFunctionFactory {
  def create = new ControlFunction().respond _
}

class ControlFunction extends InputDispatching
  with NonStunningRandomWalking
  with NonStunningStupidHarvesting
  with RandomSpawning
