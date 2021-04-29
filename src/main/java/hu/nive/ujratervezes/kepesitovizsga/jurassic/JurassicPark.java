package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {

    private MariaDbDataSource dataSource;

    public JurassicPark(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        List<String> result = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT breed FROM dinosaur WHERE actual > expected");
                ResultSet rs = stmt.executeQuery();
        ) {

            while (rs.next()) {
                result.add(rs.getString("breed"));
            }

        } catch (SQLException sql) {
            throw new IllegalStateException("Cannot connect", sql);
        }

        return result;
    }
}
