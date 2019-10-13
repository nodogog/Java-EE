package ge.digitaledu.sms.controller;

import ge.digitaledu.sms.utils.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        request(req, resp, Method.GET);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        request(req, resp, Method.POST);
    }

    abstract protected void request(HttpServletRequest req, HttpServletResponse resp, Method method);
}
