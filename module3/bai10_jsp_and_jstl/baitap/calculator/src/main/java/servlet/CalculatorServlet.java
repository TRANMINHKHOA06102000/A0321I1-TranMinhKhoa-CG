package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"","/CalculatorServlet"})
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num_one"));
        int num2 = Integer.parseInt(request.getParameter("num_second"));
        int result = 0;

        String err = null;
        String ope = request.getParameter("operator");
        try {
            switch (ope) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    err = "Phép tính không phù hợp";
                    break;
            }
        } catch (Exception e) {
            err = e.getMessage();
        }
        if(num2==0 && ope=="/"){
            err="Divide by zero";
        }
        request.setAttribute("number1",num1);
        request.setAttribute("number2",num2);
        request.setAttribute("err", err);
        request.setAttribute("ope",ope);
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
