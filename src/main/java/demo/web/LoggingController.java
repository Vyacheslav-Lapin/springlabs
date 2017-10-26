package demo.web;

import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class LoggingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        log.info("I am here!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
