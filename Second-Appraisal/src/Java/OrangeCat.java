package Java;

public class OrangeCat extends Cat{
    boolean isFat;
    public OrangeCat(String name, int age, boolean gender, double price) {
        super(name, age, gender, price);
    }
    public OrangeCat(String name, int age, boolean gender,boolean isFat) {
        super(name, age, gender, 200);
        this.isFat=isFat;
    }

}
