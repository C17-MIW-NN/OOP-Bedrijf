package database;

import model.Werknemer;

import java.sql.SQLException;

/**
 * @author Vincent Velthuizen
 */
public class WerknemerDAO extends PersoonDAO {

    public WerknemerDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaOp(Werknemer werknemer) {
        int personeelsnummer = slaPersoonOp(werknemer);

        String sql = "INSERT INTO Werknemer (personeelsnummer, maandsalaris) VALUES (?, ?);";
        setupPreparedStatement(sql);

        try {
            getPreparedStatement().setInt(1, personeelsnummer);
            getPreparedStatement().setDouble(2, werknemer.getMaandsalaris());
        } catch (SQLException sqlException) {
            sqlExceptionWarning(sqlException);
        }

        executeManipulateStatement();
    }
}
