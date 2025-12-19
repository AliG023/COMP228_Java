package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static final Logger logger = Logger.getLogger(Database.class.getName());
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/Week9";
    private static final String DB_USER = Dotenv.get("DB_USER", "");
    private static final String DB_PASSWORD = Dotenv.get("DB_PASSWORD", "");

    private Database() {

    }

    // Establish Database Connection
    public static Connection getDBConnection() throws SQLException {
        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        }

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        }

        return connection;
    }

    // Save Applicant to Database
    public static boolean saveApplicant(Applicant app) {
        String sql = "INSERT INTO applicants (firstname, lastname, email, website, position, salary, startdate, phone, fax, lastcompany) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = getDBConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, app.getFirstName());
            ps.setString(2, app.getLastName());
            ps.setString(3, app.getEmail());
            ps.setString(4, app.getWebsite());
            ps.setString(5, app.getPosition());
            ps.setInt(6, app.getSalary());
            ps.setString(7, app.getStartDate());
            ps.setInt(8, app.getPhone());
            ps.setInt(9, app.getFax());
            ps.setString(10, app.getCompany());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Failed to save applicant: " + ex.getMessage(), ex);
            return false;
        }
    }

    // Get ALL Applicants from Database
    public static List<Applicant> getAllApplicants() {
        List<Applicant> applicants = new ArrayList<>();
        String sql = "SELECT * FROM applicants";
        try (Connection conn = getDBConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Applicant app = new Applicant();
                app.setFirstName(rs.getString("firstname"));
                app.setLastName(rs.getString("lastname"));
                app.setEmail(rs.getString("email"));
                app.setWebsite(rs.getString("website"));
                app.setPosition(rs.getString("position"));
                app.setSalary(rs.getInt("salary"));
                app.setStartDate(rs.getString("startdate"));
                app.setPhone(rs.getInt("phone"));
                app.setFax(rs.getInt("fax"));
                app.setCompany(rs.getString("lastcompany"));
                applicants.add(app);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Failed to retrieve applicants: " + ex.getMessage(), ex);
        }
        return applicants;
    }
}