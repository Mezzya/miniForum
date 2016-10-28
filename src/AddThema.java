import temp.Forum;
import temp.Message;
import temp.Thema;
import temp.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by User on 28.10.2016.
 */
public class AddThema extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if ((session.getAttribute("activeuser")!=null) && (session.getAttribute("forum")!=null))
        {
            System.out.println(">> Активный пользователь присутствует");

            String title = req.getParameter("title");

            if (title.equals(""))
            {
//                Пустое сообщение при передаче возвращаем ошибку
                resp.sendRedirect("/forum.jsp?error=incorrectly filled fields");
                return;
            }

//            Все гуд создаем новый мессадж

            Forum forum = (Forum) session.getAttribute("forum");
            Thema th = forum.getThema(title);

            if (th!=null)
            {
//                  Отправляемся назад c ошибкой. Такая тема есть
                resp.sendRedirect("/forum.jsp?error=this theme already exists");
                return;
            }

//            Все ок добавляем новую тему
            Thema thema = new Thema(title,(User) session.getAttribute("activeuser"));
//            Сохраняем
            forum.getThemas().add(thema);
            forum.saveXML("d:\\forum.xml");
            System.out.println(">> Сохраняем форум в XML");
            resp.sendRedirect("/forum.jsp");


        }



    }
}
