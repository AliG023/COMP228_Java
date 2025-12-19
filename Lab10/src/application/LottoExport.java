package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LottoExport {
    
    // Save Pick to Database
    public static void savePicktoDatabase(int min, int max, int qty, String results){
        String insert = "INSERT INTO lotto (min_number, max_number, qty_balls, results) VALUES (?, ?, ?, ?)";

        try (Connection connect = Database.getDBConnection();
                PreparedStatement stmt = connect.prepareStatement(insert)) {
                    stmt.setInt(1, min);
                    stmt.setInt(2, max);
                    stmt.setInt(3, qty);
                    stmt.setString(4, results);
                    stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}

