package demo.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form-parse")
public class FormParseController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try (PrintWriter out = resp.getWriter()) {
            out.printf("Your login: %s<br />Your password: %s",
                    login, password);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        doPost(req, resp);
    }
}
