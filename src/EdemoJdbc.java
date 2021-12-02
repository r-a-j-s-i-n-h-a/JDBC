import java.sql.*;

public class EdemoJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");  // only use for Mysql database
        // oracle.jdbc.oracledriver          // for Oracle database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","");

        Statement s= con.createStatement();
        ResultSet rs = s.executeQuery("select * from stu");
        while (rs.next())
        {
            System.out.println(rs.getString(2)+" "+ rs.getInt(3));
        }
        s.close();
        rs.close();
        con.close();
    }
}
