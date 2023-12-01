<%@ page language="java" contentType="text/html; charset=utf-8"
         import="control.Card"
         import="java.util.ArrayList"
         pageEncoding="utf-8"%>

<html>
<body>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #ee8989;
        padding: 20px;
    }

    h2 {
        text-align: center;
        color: #333;
    }

    a {
        text-decoration: none;
        color: #007bff;
    }

    form {
        width: 300px;
        margin: 0 auto;
        background-color: #ee8989;
        border: 1px solid #ee8989;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin-bottom: 10px;
        color: #555;
    }

    input[type="text"],
    input[type="date"],
    input[type="number"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ee8989;
        border-radius: 3px;
        box-sizing: border-box;
        margin-bottom: 20px;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: #ee8989;
        border: none;
        padding: 10px 20px;
        border-radius: 3px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    thead th {
        background-color: #007bff;
        color: #ee8989;
        padding: 10px;
        text-align: left;
    }

    tbody td {
        border-bottom: 1px solid #ee8989;
        padding: 10px;
    }

    tbody tr:nth-child(even) {
        background-color: #ee8989;
    }

    tbody tr:hover {
        background-color: #ee8989;
    }
</style>

<h2 style="margin-bottom:5px">Admin page</h2>
<a style="display:flex;justify-content:center" href="login">Exit</a><br><br>

<h2>Add new card</h2>
<form action="addCard" method="post">
    <label for="firstName">FirstName:</label>
    <input type="text" id="firstName" name="firstName" required><br>

    <label for="lastName">LastName:</label>
    <input type="text" id="lastName" name="lastName" required><br>

    <label for="bornDate">Born date:</label>
    <input type="date" id="bornDate" name="bornDate" required><br>

    <label for="num_visit">Number Of Visits:</label>
    <input type="number" id="num_visit" name="num_visit" required><br>

    <label for="discount">Discount:</label>
    <input type="number" id="discount" name="discount" required><br>

    <input type="submit" value="Add card">
</form>

<table>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Born Date</th>
        <th>Number Of Visits</th>
        <th>Discount</th>
    </tr>
    </thead>
    <tbody>

    <% ArrayList <Card> cards = (ArrayList<Card>)request.getAttribute("cards"); %>
    <% for (Card card : cards) { %>
    <tr>
        <td><%= card.getFirstname() %></td>
        <td><%= card.getLastname() %></td>
        <td><%= card.getBorn_date() %></td>
        <td><%= card.getNum_visit() %></td>
        <td><%= card.getDiscount() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

</body>
</html>

