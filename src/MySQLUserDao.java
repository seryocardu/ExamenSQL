import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDao implements UserDao {

    final String INSERT = "";
    final String UPDATE = "";
    final String DELETE = "";
    final String GETONE = "";
    final String GETALL = "";

    private Connection conn;

    public MySQLUserDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void delete(User u) throws DAOException {
        PreparedStatement stat = null;

        try {
            stat = conn.prepareStatement(DELETE);
            stat = setString(1, u.getId().toString());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que no se haya borrado el usuario");
            }

        } catch (SQLException ex) {
            throw new DAOException("Error en sql", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en sql", ex);
                }
            }
        }
    }

    private PreparedStatement setString(int i, String string) {
        return null;
    }

    public User get(String id) throws DAOException {

        PreparedStatement stat = null;
        ResultSet rs = null;
        User u = null;

        try {
            stat = conn.prepareStatement(GETONE);
            stat.setString(1, id);
            rs = stat.executeQuery();

            if (rs.next()) {
                u = convert(rs);
            }
            throw new DAOException("No se ha encontrado el registro");

        } catch (SQLException ex) {
            new DAOException("Error en SQL");

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL");
                }
            }
        }
        return u;
    }

    @Override
    public List<User> getAll() throws DAOException {

        PreparedStatement stat = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();

            while (rs.next()) {
                users.add(convert(rs));
            }

        } catch (SQLException ex) {
            new DAOException("Error en SQL");

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL");
                }
            }
        }
        return users;
    }

    @Override
    public void insert(User u) throws DAOException {

        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, u.getId().toString());
            stat.setString(2, u.getName());
            stat.setString(3, u.getSurname());
            stat.setString(4, u.getEmail());
            stat.setString(5, u.getPassword());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("No se ha guardado");
            }

        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);

        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    private User convert(ResultSet rs) throws SQLException {

        String name = rs.getString("nombre");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String password = rs.getString("password");

        User user = new User(name, surname, email, password);
        user.setId(rs.getString("id"));
        return user;
    }

    @Override
    public void update(User u) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public User get(Long id) throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

}