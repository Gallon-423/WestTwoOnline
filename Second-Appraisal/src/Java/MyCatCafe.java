package Java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyCatCafe implements CatCafe {
    List<Cat> catList=new ArrayList<>();
    List<Customer> customerList=new ArrayList<>();
    double money;

    public MyCatCafe() {
    }

    public MyCatCafe(List<Cat> catList, List<Customer> customerList, double money) {
        this.catList = catList;
        this.customerList = customerList;
        this.money = money;
    }

    public List<Cat> getCatList() {
        return catList;
    }

    public void setCatList(List<Cat> catList) {
        this.catList = catList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    private String getCatMsg(Cat cat){
        if(cat instanceof OrangeCat){
            return "一只可爱的橙猫,"+cat;
        }else if(cat instanceof BlackCat)
            return "一只可爱的黑猫,"+cat;
        return "无法找到对应猫类";
    }
    @Override
    public void purchase(Cat cat) {
        if(cat.getPrice()>money){
            throw new InsufficientBalanceException("余额不足，无法买猫！");
        }else{
            money=money-cat.getPrice();
            catList.add(cat);
        }
    }

    @Override
    public void entertain(Customer c) {
        if(catList.isEmpty()){
            throw new CatNotFoundException("当前小店里没有猫哦~");
        }else{

            int cnt=0;
            while(cnt<c.getRuaTimes()){
                int index = (int) (Math.random()* catList.size());
                System.out.println(c.getName()+"正在rua"+getCatMsg(catList.get(index)));
                money+=15;
                cnt++;
            }
            System.out.println(c.getName()+"满足了~");
            customerList.add(c);
        }

    }

    @Override
    public void close() {
        LocalDate today=LocalDate.now();
        boolean hasCustomer=false;
        int ruaTimes=0;
        System.out.println("以下输出今日顾客信息：");
        for (Customer c:customerList
             ) {

            if(c.getArrive().equals(today)){
                System.out.println(c);
                hasCustomer=true;
                ruaTimes+=c.getRuaTimes();
            }

        }
        if(!hasCustomer){
            System.out.println("今日无顾客，无收入。");
        }else{
            System.out.println("今日收入为"+ruaTimes*15+"元");
        }

    }
}
