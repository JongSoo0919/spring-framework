package org.example;

import org.example.calculate.Calculator;
import org.example.calculate.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/calculate")
public class CalculatorServlet extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(CalculatorServlet.class);
    private ServletConfig servletConfig;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        logger.info("service");
        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        String operator = String.valueOf(req.getParameter("operator"));
        int operand2 = Integer.parseInt(req.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = res.getWriter();
        writer.println(result);
    }
}
