package SpringMVC.controller;

import SpringMVC.model.User;
import SpringMVC.repositories.DataBase;
import SpringMVC.repositories.H2;
import SpringMVC.utils.Constants;
import SpringMVC.view.Registration;
import com.sun.net.httpserver.HttpContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
@RequestMapping({"/", "/registration"})
public class RegistrationController {

    @GetMapping(value = "/")
    public ModelAndView getHome() {
        return new ModelAndView("redirect:/registration");
    }


    @GetMapping(value = "/registration")
    public ModelAndView getRegistration() {
        return new ModelAndView("registration");
    }

    @PostMapping(value = "/registration")
    @ModelAttribute("user")
    protected ModelAndView registerUser(@RequestParam String userName, @RequestParam String checkbox, Model model) throws SQLException, ClassNotFoundException { //(,)
        // model.addAttribute("userName", userName);
        ModelAndView modelAndView = null;
        User user = new User();
        DataBase db = new H2();
        try {
            db.createConnection();
            if (db.checkUser(userName) == null) {
                db.createNewUser(userName, "");
                user = db.checkUser(userName);
            }
            model.addAttribute("user", user);

            //      HttpSession session = HttpContext.Session();
            //      HttpSession session = Request.getSession();

            if (checkbox.equals("on")) {
                // session.setAttribute("user", user);
                modelAndView = new ModelAndView("redirect:/order");
                // Response.sendRedirect(request.getContextPath() + "/order");
            } else {
                modelAndView = new ModelAndView("redirect:/404");
                // response.sendRedirect(request.getContextPath() + "/errorForm");
            }
            db.closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return modelAndView;
    }
}