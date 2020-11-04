package SpringMVC.controller;

import SpringMVC.model.Good;
import SpringMVC.repositories.DataBase;
import SpringMVC.repositories.H2;
import SpringMVC.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrdersController {

    @GetMapping("/order")
    public ModelAndView makeOrder(Model model) {
        DataBase db = new H2();

        List<Good> goodList = null;
        try {
            db.createConnection();
            goodList = db.getGoodList();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
       // request.getSession().setAttribute("goodList", goodList);
        model.addAttribute("goodList", goodList);

        db.closeConnection();
       // RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constants.ORDER_PAGE);
       // requestDispatcher.forward(request, response);
        return new ModelAndView("redirect:/order");
    }

    @PostMapping()
    protected void doPost() {
    }
}
