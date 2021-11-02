package Java_1;

public abstract class  Cat {
    protected String name;
    protected int age;
    protected boolean gender;
    protected double price;

    public Cat(String name, int age, boolean gender, double price) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
    }

    @Override
    public String toString() {
        String gen=gender?"公猫":"母猫";
        return "猫猫的信息为：" +
                "名字是 '" + name + '\'' +
                ", 年龄是" + age +
                "岁, 是一只" + gen +
                ", 售价为" + price + "元。"
                ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) throws Exception {
        if(age <0) throw new Exception("猫的年龄不能是负数！");
        this.age = age;
    }

    public boolean Gender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
