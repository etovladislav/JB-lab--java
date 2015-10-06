import javafx.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer operation = 1;
        BigDecimal firstNumber = null;
        BigDecimal secondNumber;

        Pair<Boolean, String> error = new Pair<Boolean, String>(false, "");

        BigDecimal answer = new BigDecimal(0);
        operation = Integer.parseInt(req.getParameter("operation"));
        if (req.getParameter("number-1") != null) {
            firstNumber = new BigDecimal(req.getParameter("number-1"));
        }
        secondNumber =  new BigDecimal(req.getParameter("number-2"));

        switch (operation) {
            case 1:
                answer = firstNumber.add(secondNumber);
                break;
            case 2:
                answer = firstNumber.remainder(secondNumber);
                break;
            case 3:
                answer = firstNumber.multiply(secondNumber);
                break;
            case 4:
                try {
                    if (secondNumber.toString().equals("0"))
                        throw new ArithmeticException();

                    answer = firstNumber.divide(secondNumber);
                } catch (Exception ex) {
                    error = new Pair<Boolean, String>(true, "you can not divide by zero");
                }
                break;
        }

        HttpSession session = req.getSession(false);

        if (error.getKey() == true) {
            session.setAttribute("error", error.getValue());
        } else {
            session.setAttribute("answer", answer.toString());
        }
        resp.sendRedirect("/calculator");
    }
}
