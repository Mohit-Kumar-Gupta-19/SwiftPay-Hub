package service;

import db.DBConnection;
import util.PasswordUtil;
import java.sql.*;

public class BankService {

    // REGISTER
    public void register(String name, String email, String password) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO users(name,email,password) VALUES (?,?,?)"
        );
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, PasswordUtil.hash(password));
        ps.executeUpdate();

        ResultSet rs = con.createStatement()
                .executeQuery("SELECT user_id FROM users WHERE email='" + email + "'");
        rs.next();
        int userId = rs.getInt(1);

        PreparedStatement acc = con.prepareStatement(
            "INSERT INTO accounts(user_id,balance) VALUES (?,0)"
        );
        acc.setInt(1, userId);
        acc.executeUpdate();
    }

    // LOGIN
    public int login(String email, String password) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT user_id,password FROM users WHERE email=?"
        );
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getString("password")
                .equals(PasswordUtil.hash(password))) {
            return rs.getInt("user_id");
        }
        return -1;
    }

    // FORGOT PASSWORD
    public void resetPassword(String email, String newPassword) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE users SET password=? WHERE email=?"
        );
        ps.setString(1, PasswordUtil.hash(newPassword));
        ps.setString(2, email);
        ps.executeUpdate();
    }

    // BALANCE
    public double getBalance(int userId) throws Exception {
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement().executeQuery(
            "SELECT balance FROM accounts WHERE user_id=" + userId
        );
        return rs.next() ? rs.getDouble(1) : 0;
    }

    // DEPOSIT
    public void deposit(int userId, double amt) throws Exception {
        Connection con = DBConnection.getConnection();
        con.createStatement().executeUpdate(
            "UPDATE accounts SET balance = balance + " + amt + " WHERE user_id=" + userId
        );
        addTransaction(userId, "DEPOSIT", amt);
    }

    // WITHDRAW
    public void withdraw(int userId, double amt) throws Exception {
        Connection con = DBConnection.getConnection();
        con.createStatement().executeUpdate(
            "UPDATE accounts SET balance = balance - " + amt + " WHERE user_id=" + userId
        );
        addTransaction(userId, "WITHDRAW", amt);
    }

    // TRANSACTION
    private void addTransaction(int userId, String type, double amt) throws Exception {
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement().executeQuery(
            "SELECT account_id FROM accounts WHERE user_id=" + userId
        );
        rs.next();
        int accId = rs.getInt(1);

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO transactions(account_id,type,amount) VALUES (?,?,?)"
        );
        ps.setInt(1, accId);
        ps.setString(2, type);
        ps.setDouble(3, amt);
        ps.executeUpdate();
    }

    // CONTACT
    public void contact(String name, String email, String subject, String msg) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO contact(name,email,subject,message) VALUES (?,?,?,?)"
        );
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, subject);
        ps.setString(4, msg);
        ps.executeUpdate();
    }

    // FEEDBACK
    public void feedback(String name, String email, String msg) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO feedback(name,email,message) VALUES (?,?,?)"
        );
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, msg);
        ps.executeUpdate();
    }
}
