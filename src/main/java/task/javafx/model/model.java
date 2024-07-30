package task.javafx.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class model {
    private Connection connection;

    public model() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/F:\\OutSource\\JAVA\\vehicle\\src\\main\\resources\\task\\javafx\\car.db");
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS cars ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "number INTEGER NOT NULL, "
                + "dateOfEntry TEXT NOT NULL, "
                + "type CHAR NOT NULL, "
                + "price DOUBLE NOT NULL, "
                + "unit TEXT NOT NULL"
                + ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addCar(car car) {
        String sql = "INSERT INTO cars(name, number, dateOfEntry, type, price, unit) VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, car.getName());
            pstmt.setInt(2, car.getNumber());
            pstmt.setString(3, car.getDateOfEntry().toString());
            pstmt.setString(4, String.valueOf(car.getType()));
            pstmt.setDouble(5, car.getPrice());
            pstmt.setString(6, car.getUnit());
            pstmt.executeUpdate();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<car> getAllCars() {
        List<car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                car car = new car(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("number"),
                        LocalDate.parse(rs.getString("dateOfEntry")),
                        rs.getString("type").charAt(0),
                        rs.getDouble("price"),
                        rs.getString("unit")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    // Xóa một xe khỏi bảng cars
    public void deleteCar(String carId) {
        String sql = "DELETE FROM cars WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, carId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Đóng kết nối cơ sở dữ liệu khi không cần thiết
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
