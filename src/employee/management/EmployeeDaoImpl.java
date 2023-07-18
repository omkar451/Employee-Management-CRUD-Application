package employee.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoIntrf{
    Connection con;

    @Override
    public void createEmployee(Employee emp) {
       con =DBConnection.createDBConnetion();
       String query="insert into employeedb values(?,?,?,?)";
       try{
           PreparedStatement pstm=con.prepareStatement(query);
           pstm.setInt(1,emp.getId());
           pstm.setString(2,emp.getName());
           pstm.setInt(3,emp.getSalary());
           pstm.setInt(4,emp.getAge());
          int cnt= pstm.executeUpdate();
          if(cnt!=0)
              System.out.println("Employee Inserted Successfully !!!");


       }catch (Exception ex){
           System.out.println("Invalid Employee Id !!! \nPlease Enter another Employee Id. ");
//           ex.printStackTrace();
       }

    }

    @Override
    public void showAllEmployee() {
        con=DBConnection.createDBConnetion();
        String query="select * from employeedb";
        System.out.println("Employee Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","age");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%d\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            System.out.println("Employee doesn't exist !!! \nPlease make entry for employee.\n");
            //ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con=DBConnection.createDBConnetion();
        String query="select * from employeedb where id="+id;
        try{
            Statement stmt=con.createStatement();
           ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%d\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4));

            }

        }
        catch (Exception ex){
            System.out.println("Please first make entry for employee");
//            ex.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con=DBConnection.createDBConnetion();
        String query="update employeedb set name=? where id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        con=DBConnection.createDBConnetion();
        String query="delete from employeedb where id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
           int cnt= pstm.executeUpdate();
           if(cnt!=0)
               System.out.println("Employee Deleted Successfully!!! "+id);

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
