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

        UsersWrapper usersWrapper = new UsersWrapper();

        String absPatch = req.getSession().getServletContext().getRealPath("/WEB-INF/");

        usersWrapper.loadXML(absPatch+"/users.xml");
        System.out.println("Users = "+ usersWrapper.getUsers());


        Forum forum = new Forum();

        forum.loadXML(absPatch+"/forum.xml");
        HttpSession session = req.getSession();
        if (req.getParameter("act")==null)
        {
            resp.sendRedirect("/index.jsp?error=Error. try again/");
            return;
        }

        if (req.getParameter("act").equals("new"))
        {
//            Регистрация
            String login = req.getParameter("login");
            String pwd = req.getParameter("password");
            String firstName = req.getParameter("firstname");
            String lastName = req.getParameter("lastname");

            if (login.equals("")||pwd.equals("")||firstName.equals("")||lastName.equals("")){
//                неверно заполненіе поля

                resp.sendRedirect("/reg.jsp?error=incorrectly filled fields");
                return;
            }

            if (usersWrapper.userLoginexist(login))
            {
//                Пользователь с таким логином уже есть
                resp.sendRedirect("/reg.jsp?error=user with this login already have");
                return;
            }

//            Добовляем нового пользователя
            User newUser= new User(firstName,lastName,login,pwd);
            if (usersWrapper.regNewUser(newUser))
            {
//                добавляем в базу
                usersWrapper.regNewUser(newUser);

                usersWrapper.saveXML(absPatch+"users.xml");
//                Все хорошо переходим на форум
                session.setAttribute("activeuser", newUser);
//                session.setAttribute("thema", forum.getThemas().get(0));
                session.setAttribute("forum", forum);
                resp.sendRedirect("/forum.jsp");
            }


        }

        if (req.getParameter("act").equals("login"))
        {

//            Пытается логинится
            String login = req.getParameter("login");
            String pwd = req.getParameter("password");
            System.out.println(">> Попытка входа пользователя - "+login);

            if (usersWrapper.chekUserPwd(login, pwd))
            {
//                Найден тайо заходим на форум
                System.out.println(">> Попытка входа удачная");
//                На форум топай
//                System.out.println(">> User is " + usersWrapper.getUser(login).getFirstName());
                session.setAttribute("activeuser", usersWrapper.getUser(login));
//                session.setAttribute("thema", forum.getThemas().get(0));
                session.setAttribute("forum", forum);

                resp.sendRedirect("/forum.jsp");

            } else
            {
//                Такой связки в базе нет. Ошибочка
                System.out.println(">> Попытка входа не удачная");
//                Топай на форму входа
                resp.sendRedirect("/index.jsp?error=Access is denied");

            }


        }


    }

    public void saveTofileUsers(UsersWrapper users)
    {
        XMLSaver saver = new XMLSaver();
        System.out.println(">> Save to users.xml");
        saver.save(users,"d:\\users.xml");
    }

}
