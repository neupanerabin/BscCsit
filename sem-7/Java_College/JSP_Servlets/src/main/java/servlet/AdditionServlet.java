package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/AdditionServlet")
public class AdditionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the HTML form
        String number1Str = request.getParameter("number1");
        String number2Str = request.getParameter("number2");

        // Convert parameters to integers
        int number1 = Integer.parseInt(number1Str);
        int number2 = Integer.parseInt(number2Str);

        // Add the numbers
        int result = number1 + number2;

        // Set the result as an attribute in the request object
        request.setAttribute("result", result);

        // Forward the request to the result.jsp page for displaying the result
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
