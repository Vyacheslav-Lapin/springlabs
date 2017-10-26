package demo.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirectController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        requestDispatcher.forward(req, resp);


        //HTTP redirect:
//        resp.sendRedirect("http://epam.com/some-url");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
