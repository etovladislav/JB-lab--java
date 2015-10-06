import javafx.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer operation = 1;
        Double firstNumber = 0.0;
        Double secondNumber = 0.0;

        Pair<Boolean, String> error = new Pair<Boolean, String>(false, "");

        double answer = 0;
        operation = Integer.parseInt(req.getParameter("operation"));
        if (req.getParameter("number-1") != null) {
            firstNumber = Double.parseDouble(req.getParameter("number-1"));
        }
        secondNumber = Double.parseDouble(req.getParameter("number-2"));

        switch (operation) {
            case 1:
                answer = firstNumber + secondNumber;
                break;
            case 2:
                answer = firstNumber - secondNumber;
                break;
            case 3:
                answer = firstNumber * secondNumber;
                break;
            case 4:
                try {
                    if (secondNumber == 0)
                        throw new ArithmeticException();

                    answer = firstNumber / secondNumber;
                } catch (Exception ex) {
                    error = new Pair<Boolean, String>(true, "you can not divide by zero");
                }
                break;
            case 5: // sin
                answer = Math.sin(secondNumber);
                break;
            case 6: // cos
                answer = Math.cos(secondNumber);
                break;
            case 7: // ln
                try {
                    if (secondNumber < 0)
                        throw new ArithmeticException();
                    answer = Math.log(secondNumber);
                } catch (Exception ex) {
                    error = new Pair<Boolean, String>(true, "ln(x), X can not be negative ");
                }
                break;
            case 8: // exp
                answer = Math.exp(secondNumber);
                break;
        }

        HttpSession session = req.getSession(false);

        if (error.getKey() == true) {
            session.setAttribute("error", error.getValue());
        } else {
            session.setAttribute("answer", answer);
        }
        resp.sendRedirect("/calculator");
    }
}
