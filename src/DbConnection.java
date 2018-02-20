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
//Lakók Combóbox feltöltése

    public void LakoCombobox() {
        try {
            String sql = "SELECT* FROM `hazkezelok` JOIN `hazak` ON `hazak`.`tk_ID` = `hazkezelok`.`id`";
            //FROM `hazak` LEFT JOIN `lakok` ON `lakok`.`Hz_ID` = `hazak`.`id` LEFT JOIN `hazkezelok` ON `hazak`.`tk_ID` = `hazkezelok`.`id`
            Statement st = kapcs.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String name ="Kezelő neve: "+rs.getString("nev")  +" Ház neve: "+rs.getString("haz") + " " + rs.getString("id");

                Lakok.Lakok_combo.addItem(name);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    //Házak Combóbox feltöltése   
    public void Fillcombo() {
        try {
            String sql = "Select * From hazkezelok";
            Statement st = kapcs.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("nev") + " " + rs.getString("id");

                Hazak.Combobox.addItem(name);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    //Ujj név felvétele a kepviselok táblába
    public void uj(String nev) {
        try {
            String s = "INSERT INTO hazkezelok(nev)VALUES('" + nev + "');";
            int sorok = update(s);
            JOptionPane.showMessageDialog(null, "Társasház kezelő hozzáadva", "Hozzáadva", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
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
            JOptionPane.showMessageDialog(null, ex.getMessage());
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
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    //Ujj Ház felvétele a haz táblába
    public void ujhaz(int kerulet, String varos, String haz, String utca, int hazszam, int tk_id) {
        try {
            String h = "INSERT INTO hazak(kerulet,varos,haz,utca,hazszam,tk_ID)VALUES('" + kerulet + "','" + varos + "','" + haz + "','" + utca + "','" + hazszam + "'," + tk_id + ");";
            int sorok = parancs.executeUpdate(h);

            JOptionPane.showMessageDialog(null, "Ház Hozzá Adva", "Suprise", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    //Ház Fissitése
    public void Hazakfriss(String kerulet, String varos, String haz, String utca, String hazszam, String id) {
        try {
            String s = "UPDATE hazak SET kerulet=('" + kerulet + "'),varos=('" + varos + "'),haz=('" + haz + "') , utca=('" + utca + "') , hazszam=('" + hazszam + "') WHERE id=('" + id + "') ;";
            int sorok = parancs.executeUpdate(s);
            JOptionPane.showMessageDialog(null, "Ház Modósitva", "Módosítva", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
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
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    //Lakó hozzáadás
    public void ujlako(String neve, int emelet, int ajto, int negyzetmeter, int Hz_ID) {
        try {
            String h = "INSERT INTO lakok(neve,emelet,ajto,negyzetmeter,Hz_ID)VALUES('" + neve
                    + "','" + emelet + "','" + ajto
                    + "','" + negyzetmeter + "'," + Hz_ID + ");";
            int sorok = parancs.executeUpdate(h);
            JOptionPane.showMessageDialog(null, "Lakó Hozzá Adva", "Suprise", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex, "Suprise", JOptionPane.ERROR);
        }
    }

    //Lakó módosit
    public void lakomodosit(String nev, String emelet, String ajto, String id) {
        try {
            String s = "UPDATE lakok SET neve=('" + nev + "') , emelet=('" + emelet + "') , ajto=('" + ajto + "') WHERE id=('" + id + "') ;";
            int sorok = parancs.executeUpdate(s);
            JOptionPane.showMessageDialog(null, "Lakó Modósitva", "Módosítva", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    //Lakó Törlése
    public void lakotorles(String nev) {
        String[] gombok = {"Igen", "Nem"};
        int v = JOptionPane.showOptionDialog(null, "Biztosan törli?", "", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, gombok, gombok[0]);
        if (v == JOptionPane.YES_OPTION) {
            try {
                String s = "DELETE FROM lakok WHERE neve=('" + nev + "');";
                int sorok = parancs.executeUpdate(s);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    //Házak ki listázása amikor az adabázisban megtalálhatók.
    public ArrayList<User> getUsersList() {
        ArrayList<User> usersList = new ArrayList<>();
        Connection connection = kapcs;

        String query = "Select *FROM `hazkezelok` JOIN `hazak` ON `hazak`.`tk_ID` = `hazkezelok`.`id` ";

        try {

            Statement st = connection.createStatement();

            ResultSet hazak = st.executeQuery(query);
            //Select *FROM `hazkezelok` JOIN `hazak` ON `hazak`.`tk_ID` = `hazkezelok`.`id`

            while (hazak.next()) {

                hazak.getInt("tk_ID");
                User user = new User(hazak.getInt("id"), hazak.getInt("kerulet"), hazak.getString("varos"), hazak.getString("haz"),
                        hazak.getString("utca"), hazak.getInt("hazszam"), hazak.getString("nev"));
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

        String query = "Select * FROM `lakok` JOIN `hazak` ON `lakok`.`Hz_ID` = `hazak`.`id` JOIN `hazkezelok` ON `hazak`.`tk_ID` = `hazkezelok`.`id`";

        try {

            Statement st = connection.createStatement();
            ResultSet lakok = st.executeQuery(query);

            while (lakok.next()) {

                Users2 user2 = new Users2(lakok.getInt("id"), lakok.getString("neve"), lakok.getInt("emelet"), lakok.getInt("ajto"), lakok.getInt("negyzetmeter"), lakok.getString("nev"));
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
        String nev;

        public User(int ID, int Kerulet, String Varos, String Haz, String Utca, int Hazszam, String Nev) {
            this.id = ID;
            this.kerulet = Kerulet;
            this.varos = Varos;
            this.haz = Haz;
            this.utca = Utca;
            this.hazszam = Hazszam;
            this.nev = Nev;

        }

        public String Nev() {
            return nev;
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
    public static class Users {

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
        public String nev1;

        public Users2(int ID, String Nev, int Emelet, int Ajto, int Negyzetmeter, String Nev1) {
            this.id = ID;
            this.nev = Nev;
            this.emelet = Emelet;
            this.ajto = Ajto;
            this.negyzetmeter = Negyzetmeter;
            this.nev1 = Nev1;
        }

        public int ID() {
            return id;
        }

        public String Nev() {
            return nev;
        }

        public String Nev1() {
            return nev1;
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
