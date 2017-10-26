package demo.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = "/parametrized",
        initParams = @WebInitParam(name = "max-age", value = "132"))
public class ParametrizedController extends HttpServlet {

    private int maxAge;

    @Override
    public void init(ServletConfig config) {
        maxAge = Integer.parseInt(
                config.getInitParameter("max-age"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head>" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" +
                    "<title>Title</title>" +
                    "</head><body>" +
                    "Max human age is " + maxAge +
                    "</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        doGet(req, resp);
    }
}
