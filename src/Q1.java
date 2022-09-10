import java.awt.Color;
import java.util.*;

// Почему создатели Java решили реализовать тип Byte, используя паттерн Интерн, а тип Long этот паттерн не реализует?
class Q1 {
  public static void main(String[] args) {
    Byte b1 = (byte)0, b2 = (byte)0, b3 = (byte)250, b4 = (byte)250;
    Integer i1 = 0, i2 = 0, i3 = 127, i4 = 127, i5 = 250, i6 = 250;
    Long l1 = 0L, l2 = 0L, l3 = 127L, l4 = 127L, l5 = 250L, l6 = 250L;
    System.out.println("b1 == b2: " + (b1 == b2) + " b3 == b4: " + (b3 == b4));
    System.out.println("i1 == i2: " + (i1 == i2) + " i3 == i4: " + (i3 == i4) + " i5 == i6: " + (i5 == i6));
    System.out.println("l1 == l2: " + (l1 == l2) + " l3 == l4: " + (l3 == l4) + " l5 == l6: " + (l5 == l6));
  }
}

