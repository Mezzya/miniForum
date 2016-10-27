import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by User on 27.10.2016.
 */
public class Login extends HttpServlet {
    Users users = new Users();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        users.getUsers().add(new User("user","user"));
        Thema thema = new Thema("Java EE",new User("user","user"));
        thema.addMessage(new Message(new User("user","user"),"Hello World!!!"));

//          Проверим логин пароль
        if (users.checkPassword(req.getParameter("name"),req.getParameter("password")))
        {
            req.setAttribute("thema",thema);
            req.getRequestDispatcher("/forum.jsp").forward(req,resp);


        } else
//            req.getRequestDispatcher("index.jsp").forward(req,resp);
//            req.setAttribute("login",req.getParameter("error"));
            resp.sendRedirect("/index.jsp?login=Access is denied");

    }

}
