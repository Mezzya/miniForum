import temp.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by temp.User on 27.10.2016.
 */
public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            User user = new User("Andrey","Megeria","mezz","mezz");
        UsersWrapper usersWrapper = new UsersWrapper();
//        usersWrapper.getUsers().add(user);
//        usersWrapper.saveXML("users.xml");
        usersWrapper.loadXML("users.xml");
        System.out.println("Users = "+ usersWrapper.getUsers());
//        saveTofileUsers(usersWrapper);

        Forum forum = new Forum();

        forum.loadXML("forum.xml");
        HttpSession session = req.getSession();



//          Проверим логин пароль
        if (usersWrapper.getUsers().get(0).getLogin().equals(req.getParameter("name")))
        {
            System.out.println(">> Login correct!!!");
           session.setAttribute("thema", forum.getThemas().get(0));
            resp.sendRedirect("/forum.jsp");


        } else {
            System.out.println(">> Login in correct "+ usersWrapper.getUsers().get(0).getLogin());
            resp.sendRedirect("/index.jsp?login=Access is denied");

        }
    }

    public void saveTofileUsers(UsersWrapper users)
    {
        XMLSaver saver = new XMLSaver();
        System.out.println(">> Save to users.xml");
        saver.save(users,"d:\\users.xml");
    }

}
