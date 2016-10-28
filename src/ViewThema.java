import temp.Forum;
import temp.Thema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by User on 28.10.2016.
 */
public class ViewThema extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String themaId = req.getParameter("id");

        if (themaId.equals(""))
        {
//            Проблемы с параметром
            resp.sendRedirect("/forum.jsp");
            return;
        }
        int id = Integer.parseInt(themaId);
        id--;

        Forum forum = (Forum) session.getAttribute("forum");

        Thema thema = forum.getThembyId(id);
        session.setAttribute("thema", thema);
        resp.sendRedirect("/thema.jsp");





    }
}
