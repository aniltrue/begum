package classes;

public class MyClass {
    public int x;
    public int y;
    public int z = -5;

    public String name = "Ali";

    public String message = "a";

    public MyClass(String name) {
        System.out.println("Const2");

        this.x = 0;
        this.y = -4;
        this.z = 3;
        this.name = name;
    }

    public MyClass(int x, int y, int z, String name) {
        System.out.println("Hello World");
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public MyClass(String name, int x, int y, int z) {
        System.out.println("Hello World2");
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public void init(int x, int y, int z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public void print() {
        System.out.println("X: " + x + " Y: " + y + " Z: " + z);
    }

    public void increaseY() {
        y += 1;
    }

    public void increaseY(int value) {
        y += value;
    }

    public void increaseZ(int value) {
        z += value;
    }

    public void increaseZ() {
        z += 1;
    }

    public int getTotal() {
        return x + y + z;
    }
}
