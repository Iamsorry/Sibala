package idv.sorry

import org.scalatest.{ FlatSpec, Matchers }

class DiceTest extends FlatSpec with Matchers {
	"Rolling a dice" should "return value within range 3 to 12" in { 
		Dice.Roll() should (be >= 3 and be <= 12)
	}
}