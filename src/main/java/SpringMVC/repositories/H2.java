package SpringMVC.repositories;

import SpringMVC.model.Good;
import SpringMVC.model.Order;
import SpringMVC.model.User;
import SpringMVC.utils.Constants;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class H2 implements DataBase {
    private Connection connection;
    private Statement statement;

    @Override
    public User checkUser(String userName) throws SQLException {
        String query = "SELECT * FROM USERS WHERE login='" + userName + "'";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String login = resultSet.getString("LOGIN");
            String password = resultSet.getString("PASSWORD");
            return new User(id, login, password);
        }
        return null;
    }

    @Override
    public void createNewUser(String userName, String password) throws SQLException {
        String query = String.format("INSERT INTO USERS(LOGIN,PASSWORD) VALUES ('%s','%s')", userName, password);
        statement.executeUpdate(query);
    }

    @Override
    public void createNewOrder(Order order) throws SQLException {
        String queryToOrders = String.format(Locale.ENGLISH, "INSERT INTO ORDERS(ID_USER, TOTAL_PRICE) VALUES (%d, %.2f)",
                order.getUserId(), order.getTotal_price());
        statement.executeUpdate(queryToOrders);
        String queryIdOrder = "SELECT SCOPE_IDENTITY()";   //последний id
        ResultSet resultSet = statement.executeQuery(queryIdOrder);
        resultSet.next();//
        int idOrder = resultSet.getInt(1);
        for (Good good : order.getGoodList()) {
            String queryToOrders_GOODS =
                    String.format("INSERT INTO ORDERS_GOODS(ID_ORDER, ID_GOOD) VALUES (%d, %d)",
                            idOrder, good.getId());
            statement.executeUpdate(queryToOrders_GOODS);
        }
    }

    @Override
    public Order getOrder(int idUser) throws SQLException {
        String queryToOrders = String.format("SELECT * FROM ORDERS WHERE ID_USER=%d", idUser);
        ResultSet resultSet = statement.executeQuery(queryToOrders);
        return null;
    }

    @Override
    public List<Good> getGoodList() throws SQLException {
        String query = "SELECT * FROM Goods";
        ResultSet resultSet = this.statement.executeQuery(query);
        List<Good> goodList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            double price = resultSet.getDouble("price");
            goodList.add(new Good(id, title, price));
        }
        return goodList;
    }

    @Override
    public void createConnection() {
        String URL = Constants.URL_BD;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URL,"sa","");

            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        DataBase db = new H2();
//        db.createConnection();
//        List<Good> goodList = db.getGoodList();
//        for (Good good: goodList
//             ) {
//            System.out.println(good.getName());
//        }
//        db.closeConnection();

}
