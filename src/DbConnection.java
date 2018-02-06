/*
 *az adatbázis csatlakozás és futatáshoz szükséges parancsok
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Balog Zsolt
 */
public class DbConnection {

    Connection kapcs = null;
    Statement parancs = null;
    ResultSet eredmeny = null;
    PreparedStatement ekp = null;

    final String dbUrl = "jdbc:mysql://localhost:3306/tarsashazkezelo";
    final String user = "root";
    final String pass = "";

    private static DbConnection dbConnection = null;

    private DbConnection() {

        try {
            //Kapcsolodás
            kapcs = DriverManager.getConnection(dbUrl, user, pass);
            System.out.println("Kapcsolat is ON");

            //parancs létrehozás
            parancs = kapcs.createStatement();

        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }

    // Singleton programozási minta
    public static DbConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DbConnection();
        }

        return dbConnection;
    }

    private int update(String query) throws SQLException {
        return parancs.executeUpdate(query);
    }

    public void kiir(int ev) {
        try {
            ekp = kapcs.prepareStatement("SELECT * FROM adatok WHERE ev = ?");
            ekp.setInt(1, ev);
            eredmeny = ekp.executeQuery();
            while (eredmeny.next()) {
                System.out.printf("%2d %-30s %-35s %-35s %d\n",
                        eredmeny.getInt("id"),
                        eredmeny.getString("nev"),
                        eredmeny.getString("lakhely"),
                        eredmeny.getInt("emelet"),
                        eredmeny.getInt("ev"));
            }
        } catch (SQLException ex) {
            System.out.println("Hiba a lekérdezésben!");
        }
    }

    public void uj(String nev) {
        try {
            String s = "INSERT INTO tarsashazkezelo(nev)VALUES('" + nev + "');";
            int sorok = update(s);
            JOptionPane.showMessageDialog(null,"Társasház kezelő hozzáadva","Suprise",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("Nem sikerült frisiteni");
        }
    }

    public void ujhaz(int kerulet, String varos, String haz, String utca, int hazszam) {
        try {
            String h = "INSERT INTO hazak(kerulet,varos,haz,utca,hazszam)VALUES('" + kerulet + "','" + varos + "','" + haz + "','" + utca + "'," + hazszam + ");";
            int sorok = parancs.executeUpdate(h);
            JOptionPane.showMessageDialog(null,"Ház Hozzá Adva","Suprise",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }
    public void ujlako(String nev, int emelet, int ajto, int negyzetmeter) {
        try {
            String h = "INSERT INTO lakok(nev,emelet,ajto,negyzetmeter)VALUES('" + nev
                    + "','" + emelet + "','" + ajto +
                    "'," + negyzetmeter +  ");";
            int sorok = parancs.executeUpdate(h);
            JOptionPane.showMessageDialog(null,"Lakó Hozzá Adva","Suprise",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,""+ex,"Suprise",JOptionPane.ERROR);
        }
    }

    public void torol(String nev) {
        try {
            String s = "DELETE FROM tarsashazkezelo WHERE nev=('" + nev + "');";
            int sorok = parancs.executeUpdate(s);
            System.out.println(sorok + " sor törölve");
        } catch (SQLException ex) {
            System.out.println("Nem sikerült törölni");
        }
    }

    public void haztorol(int id) {
        try {
            String s = "DELETE FROM tarsashazkezelo WHERE nev=('" + id + "');";
            int sorok = parancs.executeUpdate(s);
            System.out.println(sorok + " sor törölve");
        } catch (SQLException ex) {
            System.out.println("Nem sikerült törölni");
        }
    }
}
