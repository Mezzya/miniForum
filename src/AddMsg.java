import temp.Forum;
import temp.Message;
import temp.Thema;
import temp.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by User on 28.10.2016.
 */
public class AddMsg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String absPatch = req.getSession().getServletContext().getRealPath("/WEB-INF/")+ File.separator;

        if ((session.getAttribute("activeuser")!=null) && (session.getAttribute("forum")!=null))
        {
            System.out.println(">> Активный пользователь присутствует");

//            String title = req.getParameter("title");
            String message = req.getParameter("message");
            String thema = req.getParameter("thema");

            if ((thema.equals(""))||(message.equals("")))
            {
//                Пустое сообщение при передаче возвращаем ошибку
                resp.sendRedirect("/thema.jsp?error=incorrectly filled fields");
                return;
            }

//            Все гуд создаем новый мессадж

            Forum forum = (Forum) session.getAttribute("forum");
            Thema th = forum.getThema(thema);

            if (th!=null)
            {
                User user = (User) session.getAttribute("activeuser");
                user.colMsgplus();
                th.addMessage(new Message(user, message, LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));

                forum.saveXML(absPatch+"forum.xml");
//                Отправляемся назад
                resp.sendRedirect("/thema.jsp");

            }

        }


    }
}
