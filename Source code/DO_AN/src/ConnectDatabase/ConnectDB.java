
package ConnectDatabase;

import java.sql.*;

public class ConnectDB {
    protected Connection conn = null;
    public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-POPVALH\\SQLEXPRESS:1433;databaseName=TRAINTICKETMANAGEMENT;encrypt=false";
            String userName = "sa";
            String password = "12345";
            
            conn = DriverManager.getConnection(url, userName, password);
            
            if(conn != null ){
                System.out.println("Ket noi thanh cong");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return conn;
    }
}
