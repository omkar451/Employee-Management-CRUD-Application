package employee.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;
    public static Connection createDBConnetion(){

        try{
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection
           con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root", "Omk@r4545");

        }catch (Exception ex){
            ex.printStackTrace();
        }
     return con;

    }
}
