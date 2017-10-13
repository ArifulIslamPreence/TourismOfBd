import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.*;
import java.util.Objects;
import java.util.Vector;

/**
 * Created by ariful on 8/29/2016.
 */
 class DBMethod {

    Connection con = DB.getConnection();

    static boolean adminsignup(String adfirstname, String adlastname, String adusername, String adpassword) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query = "INSERT INTO `adminaccount` (adfirstname,adlastname,adusername,adpassword) VALUES ('" + adfirstname + "','" + adlastname + "','" + adusername + "','" + adpassword + "')";
            //System.out.println(query);
            stmt.executeUpdate(query);
            if (stmt.executeUpdate(query) == 1) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    static boolean adminlogin(String adusername, String adpassword) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query1 = "SELECT adusername FROM `adminaccount` WHERE adusername='" + adusername + "'";
            ResultSet rs = stmt.executeQuery(query1);
            if (!rs.next()) return false;
            else rs = stmt.executeQuery("SELECT adpassword FROM `adminaccount` WHERE adusername='" + adusername + "'");
            rs.next();
            //System.out.println(rs.getString(1));
            return Objects.equals(rs.getString(1), adpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    static void usersignup(String firstname, String lastname, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query = "INSERT INTO `useraccount` (firstname,lastname,username,password) VALUES ('" + firstname + "','" + lastname + "','" + username + "','" + password + "')";
            //System.out.println(query);
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static boolean userlogin(String username, String password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query1 = "SELECT username FROM `useraccount` WHERE username='" + username + "'";
            ResultSet rs = stmt.executeQuery(query1);
            if (!rs.next()) return false;
            else rs = stmt.executeQuery("SELECT password FROM `useraccount` WHERE username='" + username + "'");
            rs.next();
            //System.out.println(rs.getString(1));
            return Objects.equals(rs.getString(1), password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    static boolean security(String adpassword) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query3 = "SELECT securitycode FROM `security` WHERE securitycode='" + adpassword + "'";
            ResultSet rs = stmt.executeQuery(query3);

            if (!rs.next()) return false;
            else rs = stmt.executeQuery("SELECT securitycode FROM `security` WHERE securitycode='" + adpassword + "'");
            rs.next();

            return Objects.equals(rs.getString(1), adpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    static Vector<String> district() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query1 = "SELECT `DNAME` FROM `district`";
            ResultSet rs = stmt.executeQuery(query1);

            Vector<String> vector = new Vector<>();
            while (rs.next()) {
                vector.add(rs.getString(1));
            }
            return vector;
        } catch (SQLException e) {
            System.out.println("Nothing");
            e.printStackTrace();
            return new Vector<String>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static Vector<String> place(String district)    {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query1 = "SELECT `SNAME` FROM `spot` WHERE spot.DID=(SELECT `DID` FROM district WHERE DNAME='" + district + "')";
            System.out.println(query1);
            ResultSet rs = stmt.executeQuery(query1);


            Vector<String> vector = new Vector<>();
            while (rs.next()) {
                vector.add(rs.getString(1));

            }
            return vector;


        } catch (SQLException e) {
            e.printStackTrace();
            return null; //new Vector<String>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static String Hotel(String spot) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query1 = "SELECT `HNAME` FROM `hotel` WHERE hotel.SID=(SELECT `SID` FROM spot WHERE spot.SNAME='" + spot + "')";
            System.out.println(query1);
            ResultSet rs = stmt.executeQuery(query1);
            //rs.next();
            /*String ret[]=new String[2];
            ret[0]=rs.getString(1);
            rs.next();
            String  query2="SELECT `Hotel fare` FROM `table 1` WHERE `Suggested Hotel`='"+ret[0]+"'";
            ResultSet rs2 = stmt.executeQuery(query2);
            rs2.next();
            ret[1]=rs2.getString(1);
            //System.out.println(ret[1]);
            rs2.next();
            return ret;*/
            //Vector<String> vector = new Vector<>();
            if (rs.next())
                return rs.getString(1);
            else return "rtre";
            //return vector;
        } catch (SQLException e) {
            e.printStackTrace();
            //return new Vector<String>();
            return  "sgdg";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "sdsd";

    }

    static String busFare(String spotname) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query1 = "SELECT `Busfare` FROM `spot` WHERE `sname`='" + spotname + "'";
            System.out.println(query1);
            ResultSet rs = stmt.executeQuery(query1);
            rs.next();
            System.out.println(rs.getString(1));
            return rs.getString(1);
        } catch (Exception e) {
        }
        return null;
    }

    static String distance(String distance) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query1 = "SELECT `DISTANCE` FROM `spot` WHERE `sname`='" + distance + "'";
            ResultSet rs = stmt.executeQuery(query1);
            rs.next();
            System.out.println(rs.getString(1));
            return rs.getString(1);
        } catch (Exception e) {
        }
        return null;
    }

    static void districtedit(String district, String mood) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query = " ";

            if (mood.equals("add"))
                query = "INSERT INTO `district` (DNAME) VALUES ('" + district + "')";
             else
                query = "DELETE FROM `district` WHERE `DNAME`='" + district + "'";

            //System.out.println(query);
            stmt.executeUpdate(query);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static boolean spotedit(String district, String spotname, String mood) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query = " ";
            String query2=" ";
            query2="SELECT `DID` FROM `district` WHERE DNAME='" + district+ "'";
            System.out.println(query2);
            ResultSet rs=stmt.executeQuery(query2);
            if(!rs.next()) return false;

            if (mood.equals("add")) {
                query = "INSERT INTO `spot` (SNAME,DID) VALUES ('" + spotname+ "','" +district+ "')";
                //stmt.executeUpdate(query);
            } else {
                query = "DELETE FROM `spot` WHERE SNAME='" +spotname + "' AND DID='" +district+ "')";
                //stmt.executeUpdate(query);
            }
            stmt.executeUpdate(query);

            //System.out.println(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    static boolean hoteledit(String spot, String hotelname, String mood) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            Statement stmt = con.createStatement();
            String query = " ";
            String query2=" ";
            query2="SELECT `SID` FROM `spot` WHERE SNAME='" + spot + "'";
            ResultSet rs=stmt.executeQuery(query2);
            if(!rs.next()) return false;

            if (mood.equals("add")) {
                query = "INSERT INTO `hotel` (HNAME,SID) VALUES ('" + hotelname+ "','" +rs.getString(1)+ "')";
            } else {
                query = "DELETE FROM `hotel` WHERE HNAME='" +hotelname + "' AND SID='" +rs.getString(1)+ "')";
            }


            //System.out.println(query);
            stmt.executeUpdate(query);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
