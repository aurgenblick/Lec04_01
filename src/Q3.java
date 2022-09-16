class Q3 {
  public static void main(String[] args) {
    D d1 = new D(); // reference type D, no class casting
    D d2 = new E(); // reference type D, upcasting to E
    D d3 = new F(); // reference type D, upcasting to F
    E e1 = new E(); // reference type E, no class casting
    E e2 = new F(); // reference type E, upcasting to F
    F f1 = new F(); // reference type F, no class casting

    d1.m(e2); //*reference type is D, object type is D, parameter reference type is E, parameter object type is F,
              // therefore, the method is chosen amongst class D methods . Static binding will choose m(E),
              // since the parameter reference type is E and class В has method m(E e).
              // DE
    e1.m(d3); //*reference type is E, object type is E, parameter reference type is D, parameter object type is F,
              // therefore, at first, the method is searched for amongst class E, where there is method m(D d) .
              // ED
    e2.m(f1); //*reference type is E, object type is F, parameter reference type is F, parameter object type is F,
              // therefore, at first, the method is searched for amongst class F, where there is method m(F f) .
              // FF
    f1.m(e2); //*reference type is F, object type is F, parameter reference type is E, parameter object type is F,
              // therefore, at first, the method is searched for amongst class F, where there is method m(F f),
              // but since the parameter reference type is E(and class F doesn't have m(E e)),
              // method is then searched for in class E which has m(E e).
              // EE
    d2.m(d3); //*reference type is D, object type is E, parameter reference type is D, parameter object type is F,
              // therefore, at first, the method is searched for amongst class E, where there is method m(F f),
              // but since the parameter reference type is D(and class E doesn't have m(E e)),
              // method is then searched for in class E which has m(E e).
              // EE
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