object Q1 {
  def main(args: Array[String]): Unit = {
    var negative= new Rational(1,4)
    println("Negative Value : "+negative.neg)
  }
  class Rational(n:Int, d:Int){
    require(d != 0,"Denominator can not be zero")
    def numerator =n
    def denominator =d

    def neg=new Rational(-this.numerator,this.denominator)
    override def toString():String= numerator + "/" + denominator
  }
}
