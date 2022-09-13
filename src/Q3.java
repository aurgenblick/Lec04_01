class Q3 {
  public static void main(String[] args) {
    D d1 = new D();
    D d2 = new E();
    D d3 = new F();
    E e1 = new E();
    E e2 = new F();
    F f1 = new F();

    d1.m(e2);
    e1.m(d3);
    e2.m(f1);
    f1.m(e2);
    d2.m(d3);
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