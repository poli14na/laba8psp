package control;

import java.sql.*;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.Integer.parseInt;


public class AddCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Card> cards = JDBC.getCardsFromDB();
        req.setAttribute("cards", cards);
        req.getRequestDispatcher("WEB-INF/JSP/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String bornDate = req.getParameter("bornDate");
        String numVisit = req.getParameter("num_visit");
        String discount = req.getParameter("discount");

        ArrayList<Card> cards = JDBC.getCardsFromDB();
        int id = 1;
        for (Card card : cards) {
            if (card.getFirstname().equals(firstName) && card.getLastname().equals(lastName) && card.getBorn_date().equals(bornDate) && card.getNum_visit().equals(numVisit) && card.getDiscount().equals(discount)) {
                req.getRequestDispatcher("WEB-INF/JSP/admin.jsp").forward(req, resp);
            }
            else {
                id++;
            }
        }
        insertCard(id, firstName, lastName, bornDate, numVisit, discount);
        resp.sendRedirect("/laba8psp/addCard");
    }

    public void insertCard(int cardId, String fistName, String lastName, String born_date, String num_visit, String discount) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab8", "root", "root");
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO cards (card_id, firstname, lastname, born_date, num_visit, discount) VALUES (?, ?, ?, ?, ?, ?)")) {

                statement.setLong(1, cardId);
                statement.setString(2, fistName);
                statement.setString(3, lastName);
                statement.setString(4, born_date);
                statement.setString(5, num_visit);
                statement.setString(6, discount);

                statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
