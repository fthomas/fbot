object TestWS {
  
 	Entity.from('M').get                      //> res0: Entity = Master
	val s = Item.from('M').get match {
		case _ => Slave
	}                                         //> s  : Slave.type = Slave
	s.isFriendly                              //> res1: Boolean = true

	Master.terrain                            //> res2: Char = _
	EmptyCell.terrain                         //> res3: Char = _
	Wall.terrain                              //> res4: Char = W
	Vector(2,3) * 4.6                         //> res5: Vector = 9:13
	
	Vector(2,4).lInfLength                    //> res6: Int = 4
	Vector(1,3).l2Length                      //> res7: Int = 3
}