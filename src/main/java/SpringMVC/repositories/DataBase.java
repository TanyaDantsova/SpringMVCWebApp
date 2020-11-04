package SpringMVC.repositories;

import SpringMVC.model.Good;
import SpringMVC.model.Order;
import SpringMVC.model.User;
import java.sql.SQLException;
import java.util.List;

public interface DataBase {
    User checkUser(String userName) throws SQLException;

    void createNewUser(String userName, String password) throws SQLException;

    List<Good> getGoodList() throws SQLException;

    void createNewOrder(Order order) throws SQLException;

    Order getOrder(int idUser) throws SQLException;

    void createConnection() throws SQLException, ClassNotFoundException;

    void closeConnection();
}

