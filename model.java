package automobile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private Connection connection;

    public Model() {
        try {
            // Kết nối đến cơ sở dữ liệu SQLite
            connection = DriverManager.getConnection("jdbc:sqlite:car_inventory.db");
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Tạo bảng cars nếu chưa tồn tại
    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS cars ("
                + "id TEXT PRIMARY KEY, "
                + "name TEXT NOT NULL, "
                + "number INTEGER NOT NULL, "
                + "filter CHAR NOT NULL, "
                + "dateOfEntry DATE NOT NULL, "
                + "type CHAR NOT NULL, "
                + "price DOUBLE NOT NULL"
                + ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Thêm một xe vào bảng cars
    public void addCar(Car car) {
        String sql = "INSERT INTO cars(id, name, number, filter, dateOfEntry, type, price) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, car.getId());
            pstmt.setString(2, car.getName());
            pstmt.setInt(3, car.getNumber());
            pstmt.setString(4, String.valueOf(car.getFilter()));
            pstmt.setDate(5, new java.sql.Date(car.getDateOfEntry().getTime()));
            pstmt.setString(6, String.valueOf(car.getType()));
            pstmt.setDouble(7, car.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả xe từ bảng cars
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Car car = new Car(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("number"),
                        rs.getString("filter").charAt(0),
                        rs.getDate("dateOfEntry"),
                        rs.getString("type").charAt(0),
                        rs.getDouble("price")
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
