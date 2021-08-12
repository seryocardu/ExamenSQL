import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AppConnection {
    public static void main(String[] args) {

        String url = System.getenv("url");
        String user = System.getenv("user");
        String pass = System.getenv("pass");

        try (Connection connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement();) {

            PreparedStatement stmt = connection.prepareStatement("insert into ingredient values(?,?,?)");
            stmt.setInt(1, 345);
            stmt.setString(2, "Blue Cheese");
            stmt.setInt(3, 3);

            stmt.executeUpdate();

            System.out.println("funciona");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}