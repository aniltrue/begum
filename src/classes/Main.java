package classes;

import java.util.ArrayList;
import java.util.AbstractList;

public class Main {
    public static void main(String[] args) {
        MyClass object1 = new MyClass(5, 10, 4, "Ali");
        MyClass object2 = new MyClass(3, 2, 1, "Veli");

        System.out.println(object1.x);
        System.out.println(object2.x);

        object1.x = 5;

        System.out.println(object1.x);
        System.out.println(object2.x);

        System.out.println();

        printObject(object1);
        object1.print();
        printObject(object2); // Methoda objeyi vererek çağırıyorsun
        object2.print(); // Obje üzerinden methodu çağırıyorsun

        System.out.println();

        object1.increaseY();
        object1.print();
        object2.print();
        object2.increaseY();
        object2.increaseY();

        object2.print();

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(5);

        System.out.println(arr1.size());

        System.out.println();

        object1.increaseZ(10);
        object1.print();

        System.out.println(object1.getTotal());
        System.out.println(object2.getTotal());

        System.out.println();

        MyClass object3 = new MyClass(10, 5, -6, "Veli");
        System.out.println(object3.z);
        System.out.println(object3.name);
        System.out.println();

        object3.init(10, 5, -6, "Veli");

        System.out.println(object3.message.toUpperCase());

        MyClass object4 = new MyClass("Ayşe");

        MyClass object5 = new MyClass("Str", 1, 2, 3);

        arr1.add(5);
        arr1.add(0, 4);

        object5.increaseZ();
        object5.increaseZ(4);
        // object5.increaseZ(4, 3); Böyle bir method yok, o yüzden hata verir.

        // AbstractList<Integer> arr3 = new ArrayList<>();
    }

    public static void printObject(MyClass obj) {
        System.out.println("X: " + obj.x + " Y: " + obj.y + " Z: " + obj.z);
    }
}
