object TestWS {
  
 	Entity.from('M').get                      //> res0: Entity = Master
	val s = Item.from('M').get match {
		case _ => Slave
	}                                         //> s  : Slave.type = Slave
	s.isFriendly                              //> res1: Boolean = true

	Master.terrain                            //> res2: Char = _
	EmptyCell.terrain                         //> res3: Char = _
	Wall.terrain                              //> res4: Char = W
}