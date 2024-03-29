package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Override
    public void init() throws ServletException {
        requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        log.info("[DispatcherServlet] started.");

        try {
            Controller handler = requestMappingHandlerMapping.findHandler(req.getRequestURI());
            String viewName = handler.handleRequest(req, resp);

            RequestDispatcher dispatcher = req.getRequestDispatcher(viewName);
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            log.error("exception occured: [{}]", e.getMessage(), e);
        }
    }
}
