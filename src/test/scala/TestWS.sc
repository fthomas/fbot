object TestWS {
  val w = Welcome(Map("name"->"", "apocalypse"->"0", "round"->"0", "maxslaves" -> "0"))
                                                  //> w  : Welcome = Welcome(name=,apocalypse=0,round=0,maxslaves=0)
  w.params                                        //> res0: Map[String,String] = Map(name -> "", apocalypse -> 0, round -> 0, maxs
                                                  //| laves -> 0)
 // GoodBye(Map("energy" -> "0"))
  
  /*
 	Entity.from('M').get
	val s = Item.from('M').get match {
		case _ => Slave
	}
	s.isFriendly

	Master.terrain
	EmptyCell.terrain
	Wall.terrain
	Vector(2,3) * 4.6
	
	Vector(2,4).lInfLength
	Vector(1,3).l2Length*/
}