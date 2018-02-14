/*
 *az adatbázis csatlakozás és futatáshoz szükséges parancsok
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

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
    final JPanel panel = new JPanel();
    private static DbConnection dbConnection = null;

//Kapcsolodás az adatbázisal
    private DbConnection() {

        try {
            //Kapcsolodás
            kapcs = DriverManager.getConnection(dbUrl, user, pass);
            JOptionPane.showMessageDialog(null, "Kapcsolat A SQL Szerverrel sikeresen létrejött!", "MYSQL JDBC", JOptionPane.INFORMATION_MESSAGE);

            //parancs létrehozás
            parancs = kapcs.createStatement();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(panel, "Kapcsolat A SQL Szerverrel nemsikerült létrehozni", "Warning",
                    JOptionPane.ERROR_MESSAGE);;
        }
    }

    //Ujj név felvétele a kepviselok táblába
    public void uj(String nev) {
        try {
            String s = "INSERT INTO hazkezelok(nev)VALUES('" + nev + "');";
            int sorok = update(s);
            JOptionPane.showMessageDialog(null, "Társasház kezelő hozzáadva", "Hozzáadva", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("Nem sikerült frisiteni");
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

   

    

    

    //kepviselok frissitése
    public void keviselofriss(String nev, String id) {
        try {
            String s = "UPDATE hazkezelok SET nev=('" + nev + "') WHERE id=('" + id + "') ;";
            int sorok = parancs.executeUpdate(s);
            JOptionPane.showMessageDialog(null, "Társasház kezelő Modósitva", "Módosítva", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }

//Képviselő törlése
    public void kepviselotorol(String nev) {
        String[] gombok = {"Igen", "Nem"};
        int v = JOptionPane.showOptionDialog(null, "Biztosan törli?", "", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, gombok, gombok[0]);
        if (v == JOptionPane.YES_OPTION) {
            try {
                String s = "DELETE FROM hazkezelok WHERE nev=('" + nev + "');";
                int sorok = parancs.executeUpdate(s);

            } catch (SQLException ex) {
                System.out.println("Nem sikerült törölni");
            }
        }
    }
    

    //Ujj Ház felvétele a haz táblába
    public void ujhaz(int kerulet, String varos, String haz, String utca, int hazszam) {
        try {
            String h = "INSERT INTO hazak(kerulet,varos,haz,utca,hazszam)VALUES('" + kerulet + "','" + varos + "','" + haz + "','" + utca + "'," + hazszam + ");";
            int sorok = parancs.executeUpdate(h);

            JOptionPane.showMessageDialog(null, "Ház Hozzá Adva", "Suprise", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }

    //Ház Fissitése
    public void Hazakfriss(String kerulet, String varos, String haz, String utca, String hazszam, String id) {
        try {
            String s = "UPDATE hazak SET kerulet=('" + kerulet + "'),varos=('" + varos + "'),haz=('" + haz + "') , utca=('" + utca + "') , hazszam=('" + hazszam + "') WHERE id=('" + id + "') ;";
            int sorok = parancs.executeUpdate(s);
            JOptionPane.showMessageDialog(null, "Ház Modósitva", "Módosítva", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }
    
     //Ház törlése
    public void Haztorlese(String id) {
        String[] gombok = {"Igen", "Nem"};
        int v = JOptionPane.showOptionDialog(null, "Biztosan törli?", "", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, gombok, gombok[0]);
        if (v == JOptionPane.YES_OPTION) {
            try {
                String s = "DELETE FROM hazak WHERE id=('" + id + "');";
                int sorok = parancs.executeUpdate(s);

            } catch (SQLException ex) {
                System.out.println("Nem sikerült törölni");
            }
        }
    }
    
    //Ujj lako felvétele
    public void ujlako(String nev, int emelet, int ajto, int negyzetmeter) {
        try {
            String h = "INSERT INTO lakok(nev,emelet,ajto,negyzetmeter)VALUES('" + nev
                    + "','" + emelet + "','" + ajto
                    + "'," + negyzetmeter + ");";
            int sorok = parancs.executeUpdate(h);
            JOptionPane.showMessageDialog(null, "Lakó Hozzá Adva", "Suprise", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex, "Suprise", JOptionPane.ERROR);
        }
    }

    //Lakó módosit
    public void lakomodosit(String nev, String emelet, String ajto, String id) {
        try {
            String s = "UPDATE lakok SET nev=('" + nev + "') , emelet=('" + emelet + "') , ajto=('" + ajto + "') WHERE id=('" + id + "') ;";
            int sorok = parancs.executeUpdate(s);
            JOptionPane.showMessageDialog(null, "Lakó Modósitva", "Módosítva", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }

    //Lakó Törlése
    public void lakotorles(String nev) {
        String[] gombok = {"Igen", "Nem"};
        int v = JOptionPane.showOptionDialog(null, "Biztosan törli?", "", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, gombok, gombok[0]);
        if (v == JOptionPane.YES_OPTION) {
            try {
                String s = "DELETE FROM lakok WHERE nev=('" + nev + "');";
                int sorok = parancs.executeUpdate(s);

            } catch (SQLException ex) {
                System.out.println("Nem sikerült törölni");
            }
        }
    }

    //Lakó Frissitése
    public void lako(String nev, String emelet, String ajto, String negyzetmeter, String id) {
        try {
            String s = "UPDATE hazkezelok SET nev=('" + nev + "'),emelet=('" + emelet + "'),ajto=('" + ajto + "'),negyzetmeter=('" + negyzetmeter + "') WHERE id=('" + id + "') ;";
            int sorok = parancs.executeUpdate(s);
            JOptionPane.showMessageDialog(null, "Társasház kezelő Modósitva", "Módosítva", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }

    //Házak ki listázása amikor az adabázisban megtalálhatók.
    public ArrayList<User> getUsersList() {
        ArrayList<User> usersList = new ArrayList<>();
        Connection connection = kapcs;

        String query = "SELECT * FROM `hazak` ";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getInt("kerulet"), rs.getString("varos"), rs.getString("haz"), rs.getString("utca"), rs.getInt("hazszam"));
                usersList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;

    }
    
    //Lakók ki iratása táblázatba
    public ArrayList<Users2> lako() {
        ArrayList<Users2> usersList2 = new ArrayList<>();
        Connection connection = kapcs;

        String query = "SELECT * FROM `lakok` ";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Users2 user2 = new Users2(rs.getInt("id"), rs.getString("nev"), rs.getInt("emelet"), rs.getInt("ajto"), rs.getInt("negyzetmeter"));
                usersList2.add(user2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList2;

    }

    //társasház kezelők táblába helyezése
    public ArrayList<Users> getkezelo() {
        ArrayList<Users> usersList1 = new ArrayList<>();
        Connection connection = kapcs;

        String query = "SELECT * FROM `hazkezelok` ";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Users user1 = new Users(rs.getInt("id"), rs.getString("nev"));
                usersList1.add(user1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList1;

    }
    
    //ház lekérdezéséhez szükséges
    static class User {

        public int id;
        public int kerulet;
        public String varos;
        public String haz;
        public String utca;
        public int hazszam;

        public User(int ID, int Kerulet, String Varos, String Haz, String Utca, int Hazszam) {
            this.id = ID;
            this.kerulet = Kerulet;
            this.varos = Varos;
            this.haz = Haz;
            this.utca = Utca;
            this.hazszam = Hazszam;
        }

        public int getId() {
            return id;
        }

        public int Kerulet() {
            return kerulet;
        }

        public String Varos() {
            return varos;
        }

        public String Haz() {
            return haz;
        }

        public String Utca() {
            return utca;
        }

        public int Hazszam() {
            return hazszam;
        }
    }

    //Társasházu kezelőkhöz szükséges
    static class Users {

        public int id;
        public String nev;

        public Users(int ID, String Nev) {
            this.id = ID;
            this.nev = Nev;

        }

        public int ID() {
            return id;
        }

        public String Nev() {
            return nev;
        }

    }

    //Lakokhoz szükséges
    static class Users2 {

        public int id;
        public String nev;
        public int emelet;
        public int ajto;
        public int negyzetmeter;

        public Users2(int ID, String Nev, int Emelet, int Ajto, int Negyzetmeter) {
            this.id = ID;
            this.nev = Nev;
            this.emelet = Emelet;
            this.ajto = Ajto;
            this.negyzetmeter = Negyzetmeter;
        }

        public int ID() {
            return id;
        }

        public String Nev() {
            return nev;
        }

        public int Emelet() {
            return emelet;
        }

        public int Ajto() {
            return ajto;
        }

        public int Negyzetmeter() {
            return negyzetmeter;
        }

    }
}
