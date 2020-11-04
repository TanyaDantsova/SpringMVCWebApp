package SpringMVC.utils;

public class Constants {
    public static String cssFilesPath = "${pageContext.request.contextPath}/view/styles.css";
   // src\main\webapp\WEB-INF\view\jsp\404.jsp
    public static String ERROR_PAGE = "/view/jsp/404.jsp";
    public static String ORDER_PAGE = "/view/jsp/order.jsp";
    public static String TAB_PAGE = "/view/jsp/tab.jsp";
    public static String REGISTRATION_PAGE = "/view/jsp/registration.jsp";
    public static String URL_BD = "jdbc:h2:~/online-shop;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE";

}
