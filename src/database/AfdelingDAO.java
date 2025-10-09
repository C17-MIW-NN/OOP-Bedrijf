package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Vincent Velthuizen
 * Database interactie voor Afdeling
 */
public class AfdelingDAO extends AbstractDAO {

    public AfdelingDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        String sql = "INSERT INTO Afdeling (afdelingsnaam, afdelingsplaats) VALUES (?, ?);";
        setupPreparedStatement(sql);

        try {
            getPreparedStatement().setString(1, afdeling.getAfdelingsNaam());
            getPreparedStatement().setString(2, afdeling.getAfdelingsPlaats());
        } catch (SQLException sqlException) {
            sqlExceptionWarning(sqlException);
        }

        executeManipulateStatement();
    }

    public ArrayList<Afdeling> geefAfdelingen() {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        String sql = "SELECT afdelingsnaam, afdelingsplaats FROM Afdeling;";

        setupPreparedStatement(sql);

        try (ResultSet resultSet = executeSelectStatement()) {
            while (resultSet.next()) {
                String afdelingsnaam = resultSet.getString("afdelingsnaam");
                String afdelingsplaats = resultSet.getString("afdelingsplaats");
                afdelingen.add(new Afdeling(afdelingsnaam, afdelingsplaats));
            }
        } catch (SQLException sqlException) {
            sqlExceptionWarning(sqlException);
        }

        return afdelingen;
    }

    public ArrayList<Afdeling> geefAfdelingenMetPlaats(String plaats) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        String sql = "SELECT afdelingsnaam FROM Afdeling WHERE afdelingsplaats = ?;";
        setupPreparedStatement(sql);

        try {
            getPreparedStatement().setString(1, plaats);
        } catch (SQLException sqlException) {
            sqlExceptionWarning(sqlException);
        }

        try (ResultSet resultSet = executeSelectStatement()) {
            while (resultSet.next()) {
                String afdelingsnaam = resultSet.getString("afdelingsnaam");
                afdelingen.add(new Afdeling(afdelingsnaam, plaats));
            }
        } catch (SQLException sqlException) {
            sqlExceptionWarning(sqlException);
        }

        return afdelingen;
    }


}
