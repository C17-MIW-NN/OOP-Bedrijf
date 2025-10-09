package database;

import model.Persoon;

import java.sql.SQLException;

/**
 * @author Vincent Velthuizen
 */
public class PersoonDAO extends AbstractDAO {

    public PersoonDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    protected int slaPersoonOp(Persoon persoon) {
        String sql = "INSERT INTO Persoon (naam, woonplaats, afdeling) VALUES (?, ?, ?);";

        setupPreparedStatementWithKey(sql);

        try {
            getPreparedStatement().setString(1, persoon.getNaam());
            getPreparedStatement().setString(2, persoon.getWoonplaats());
            getPreparedStatement().setString(3, persoon.getAfdeling().getAfdelingsNaam());
        } catch (SQLException sqlException) {
            sqlExceptionWarning(sqlException);
        }

        return executeInsertStatementWithKey();
    }
}
