class Q3 {
  public static void main(String[] args) {
    D d1 = new D(); // reference type D, no class casting
    D d2 = new E(); // reference type D, upcasting to E
    D d3 = new F(); // reference type D, upcasting to F
    E e1 = new E(); // reference type E, no class casting
    E e2 = new F(); // reference type E, upcasting to F
    F f1 = new F(); // reference type F, no class casting

    d1.m(e2); //*Compilation :
              // calling object declared type is D, parameter declared type is E
              // -> compiler will search for the family of methods as m(E) .
              // Runtime :
              // calling object real type is D(, passed object reals type is F),
              // -> the method m(E) is first searched amongst class D methods and will choose the existing one.
              // DE
    e1.m(d3); //*Compilation :
              // calling object declared type is E, parameter declared type is D
              // -> compiler will search for the family of methods as m(D) .
              // Runtime :
              // calling object real type is E(, passed object reals type is F),
              // -> the method m(D) is first searched amongst class E methods and the existing one will be chosen .
              // ED
    e2.m(f1); //*Compilation :
              // calling object declared type is E, parameter declared type is F
              // -> compiler will search for the family of methods as m(F) .
              // Runtime :
              // calling object real type is F(, passed object reals type is F),
              // -> the method m(F) is first searched amongst class F methods and the existing one will be chosen .
              // FF
    f1.m(e2); //*Compilation :
              // calling object declared type is F, parameter declared type is E
              // -> compiler will search for the family of methods as m(E) .
              // Runtime :
              // calling object real type is F(, passed object reals type is F),
              // -> the method m(E) is first searched amongst class F methods,
              // but since there is no such method in F class, the search will be continued in F ancestor class E and
              // method m(E) of class E will be chosen .
              // EE
    d2.m(d3); //*Compilation :
              // calling object declared type is D, parameter declared type is D
              // -> compiler will search for the family of methods as m(D) .
              // Runtime :
              // calling object real type is E(, passed object reals type is F),
              // -> the method m(D) is first searched amongst class E methods,
              // but since there is no such method in E class, the search will be continued in E ancestor class D .
              // However, class D also doesn't have method m(D), and
              // -> the signature of method m() will be upcasted to Object, and the sought-for method will be m(Object),
              // -> method m(Object) of class D will be chosen .
              // DO
  }
}

class D {
  void m(Object a) { System.out.println("DO"); }
  void m(E e) { System.out.println("DE"); }
  void m(F f) { System.out.println("DF"); }
}
class E extends D {
  void m(D d) { System.out.println("ED"); }
  void m(E e) { System.out.println("EE"); }
  void m(F f) { System.out.println("EF"); }
}
class F extends E {
  void m(D d) { System.out.println("FD"); }
  void m(F f) { System.out.println("FF"); }
}