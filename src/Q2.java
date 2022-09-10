class Q2 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        A a3 = new C();
        B b1 = new B();
        B b2 = new C();
        C c1 = new C();
        I1 i1 = c1;

//        b2.m(i1);         //*статический тип B, а реальный C,
                          // компилятор идёт в тип B, потому что не видит типа C. но нужен метод m, принимающий интерфейс I1
                          // такой метод есть в классе B, который является родительским для реального типа C
                          // получится "AI1"*//
//        b2.m(c1);         //*вывод CC
        // *//
//        a1.m("ITMO");  //AO
//        a1.m(c1);         //не компилируется, потому что оба метода подходят и до обоих по одному шагу в цепочке наследования
        a2.m(b2);         //задекларирован тип А - ищем в семействе. где есть тип А . семейство методов В, которое принимает В . этоот метод не переопределен в классе В (используется тот, который унаследован от А) .
        b2.m(b2);         //
    }
}

interface I1 {
}

class A {
    void m(Object o) {
        System.out.println("AO");
    }

    B m(B b) {
        System.out.println("AB");
        return new B();
    }

    void m(I1 i) {
        System.out.println("AI1");
    }
}

class B extends A {
    void m(A a) {
        System.out.println("BA");
    }

    void m(C c1) {
        System.out.println("BC");
    }
}

class C extends B implements I1 {
    void m(C c2) {
        System.out.println("CC");
    }

    C m(B b) {
        System.out.println("CB");
        return new C();
    }
}
