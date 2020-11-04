package SpringMVC.controller;

import SpringMVC.model.Good;
import SpringMVC.model.Order;
import SpringMVC.model.User;
import SpringMVC.repositories.DataBase;
import SpringMVC.repositories.H2;
import SpringMVC.utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/tab")
public class TabServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        User user = (User) request.getSession().getAttribute("user");
        List<Good> goodList = (List<Good>) request.getSession().getAttribute("goodList");
        String[] orders = request.getParameter("input_order").split(",");
        List<Good> orderList = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            for (Good good : goodList) {
                if (orders[i].contains(good.getName())) {
                    orderList.add(good);
                }
            }
        }

        Order order = new Order(1, user.getId(), orderList);
        DataBase db = new H2();
        try {
            db.createConnection();
            db.createNewOrder(order);
            db.closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            Map<String, Integer> orderMap = new HashMap<>();
            int count;
            for (Good good : orderList) {
                String currentGoodName = good.getName();
                count = orderMap.containsKey(currentGoodName) ? orderMap.get(currentGoodName) : 0;
                orderMap.put(currentGoodName, count + 1);
            }

            for (Map.Entry<String, Integer> pair : orderMap.entrySet()) {
                System.out.println(pair.getKey() + "  " + pair.getValue());
            }
            request.setAttribute("order", orderMap);
            request.setAttribute("total", order.getTotal_price());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constants.TAB_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}