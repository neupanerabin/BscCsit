import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Addition")
public class Addition extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public Addition() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the request
        String number1Str = request.getParameter("number1");
        String number2Str = request.getParameter("number2");

        // Check if parameters are null or empty
        if (number1Str == null || number1Str.isEmpty() || number2Str == null || number2Str.isEmpty()) {
            // Handle the case when parameters are missing or empty
            response.getWriter().println("Please provide both numbers.");
            return;
        }

        try {
            // Convert parameters to integers
            int number1 = Integer.parseInt(number1Str);
            int number2 = Integer.parseInt(number2Str);

            // Add the numbers
            int sum = number1 + number2;

            // Set response content type
            response.setContentType("text/html");

            // Get the PrintWriter
            PrintWriter out = response.getWriter();

            // Write HTML response
            out.println("<html><head><title>Addition Result</title></head><body>");
            out.println("<h2>Addition Result</h2>");
            out.println("<p>Number 1: " + number1 + "</p>");
            out.println("<p>Number 2: " + number2 + "</p>");
            out.println("<p>Sum: " + sum + "</p>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            // Handle the case when parameters cannot be parsed as integers
            response.getWriter().println("Invalid number format. Please provide valid numbers.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward POST requests to the doGet method
        doGet(request, response);
    }
}
