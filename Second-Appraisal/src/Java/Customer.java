package Java;

import java.time.LocalDate;

public class Customer {
    private String name;
    private int ruaTimes;
    private LocalDate arrive;

    public Customer() {
    }

    public Customer(String name, int ruaTimes, LocalDate arrive) {
        this.name = name;
        this.ruaTimes = ruaTimes;
        this.arrive = arrive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuaTimes() {
        return ruaTimes;
    }

    public void setRuaTimes(int ruaTimes) throws Exception {
        if(ruaTimes<0) throw new Exception("rua猫的次数不能是负数！");
        this.ruaTimes = ruaTimes;
    }

    public LocalDate getArrive() {
        return arrive;
    }

    public void setArrive(LocalDate arrive) {
        this.arrive = arrive;
    }

    @Override
    public String toString() {
        return "顾客信息：" +
                "姓名为 '" + name + '\'' +
                ", 想要rua猫猫的次数是" + ruaTimes +
                "次, 到达时间是：" + arrive +".";
    }
}
