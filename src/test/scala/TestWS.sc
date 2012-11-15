object TestWS {
  val v = View("_W_" + "W_W" + "_W_")             //> v  : View = View(_W_W_W_W_)
  v.freeDirections.length                         //> res0: Int = 4
  v.freeDirections                                //> res1: List[Vec] = List(1:1, 1:-1, -1:-1, -1:1)
  v(Pos(-1,0))                                    //> res2: Option[Entity] = Some(Wall)
  !v.occupiedBy(Pos(1,0), Wall)                   //> res3: Boolean = false

  val cf = new ControlFunction                    //> cf  : ControlFunction = ControlFunction@539e6baa
  cf.respond("React(view=_____WW,generation=0,name=0,time=0,energy=0)")
                                                  //> res4: String = Move(direction=-1:1)

  Vec.allDirections                               //> res5: List[Vec] = List(0:1, 1:1, 1:0, 1:-1, 0:-1, -1:-1, -1:0, -1:1)

  //val w = Welcome(Map("name"->"", "apocalypse"->"0", "round"->"0", "maxslaves" -> "0"))
  //w.params
 
 // new Spawn(Vec(1,1))
 
 // GoodBye(Map("energy" -> "0"))
  
  
 	Entity.from('B').get                      //> res6: Entity = Fluppet
	
	/*val s = Item.from('M').get match {
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