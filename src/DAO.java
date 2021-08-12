import java.util.List;

public interface DAO<T, K> {

    void insert(T u) throws DAOException;

    void update(T u) throws DAOException;

    void delete(T u) throws DAOException;

    List<T> getAll() throws DAOException;

    T get(K id) throws DAOException;
}
