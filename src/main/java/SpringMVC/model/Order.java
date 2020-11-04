package SpringMVC.model;

import java.util.List;

public class Order {
    public Order(int orderId, int userId, List<Good> goodList) {
        this.orderId = orderId;
        this.userId = userId;
        this.goodList = goodList;
    }

    private int orderId;
    private int userId;
    private double total_price;
    private List<Good> goodList;

    public List<Good> getGoodList() {
        return goodList;
    }

    public int getUserId() {
        return userId;
    }

    public double getTotal_price() {
        double total=0.0;

        for (Good good: this.getGoodList() ) {
          total += good.getPrice();
        }
        total_price=total;
        return total_price;
    }
}
