object Q2 {
  def main(args: Array[String]): Unit = {
    var x= new Rational(3,4)
    var y= new Rational(5,8)
    var z= new Rational(2,7)

    var result= x-y-z
    println(result)
  }
  class Rational(n:Int, d:Int){
    require(d != 0,"Denominator can not be zero")
    def numerator =n
    def denominator =d

    def neg = new Rational(-this.numerator, this.denominator)
    def add(r:Rational) = new Rational(this.numerator *r.denominator + this.denominator*r.numerator, this.denominator*r.denominator)
    def -(r:Rational) = this.add(r.neg)

    override def toString():String= numerator + "/" + denominator
  }
}
