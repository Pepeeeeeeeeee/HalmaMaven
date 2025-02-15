package halmapoc.managers;

import halmapoc.extraUtil.DBConnect;
import halmapoc.model.PlayerModel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Base64;

public class AuthManager implements DBConnect {
    private String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] hashedBytes = messageDigest.digest();
            return Base64.getEncoder().encodeToString(hashedBytes); // Encoding to Base64 for safe string representation
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Hashing algorithm not found: " + e.getMessage());
            return null;
        }
    }

    // Login method using prepared statements to prevent SQL injection
    protected PlayerModel login(String name, String password) {
        String SQL = "SELECT player_id, username FROM Players WHERE username = ? AND password = ?";

        try (Connection con = DriverManager.getConnection(con_url);
             PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setString(1, name);
            stmt.setString(2, hashPassword(password));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PlayerModel(rs.getInt("player_id"), rs.getString("username"), hashPassword(password));
                }
            }
        } catch (SQLException e) {
            System.err.println("Login failed: " + e.getMessage());
        }
        return null;
    }

    // Register method with validation
    public PlayerModel register(String name, String password, String passwordConfirmation) {
        if (!password.equals(passwordConfirmation)) {
            System.err.println("Passwords do not match.");
            return null;
        }

        // Check if the player already exists
        String checkSQL = "SELECT COUNT(username) FROM Players WHERE username = ?";
        String insertSQL = "INSERT INTO Players(username, password) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(con_url);
             PreparedStatement checkStmt = con.prepareStatement(checkSQL)) {

            checkStmt.setString(1, name);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) == 0) {
                    // If player doesn't exist, insert a new one
                    try (PreparedStatement insertStmt = con.prepareStatement(insertSQL)) {
                        insertStmt.setString(1, name);
                        insertStmt.setString(2, hashPassword(password));
                        int inserted = insertStmt.executeUpdate();
                        if (inserted > 0) {
                            return login(name, password); // Log the user in after successful registration
                        }
                    }
                } else {
                    System.err.println("Username already exists.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Registration failed: " + e.getMessage());
        }
        return null;
    }
}
