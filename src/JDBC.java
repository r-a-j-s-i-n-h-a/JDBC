import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


class stu79
{
  int rollno;
  String name;

  public stu79(int rollno, String name) {
    this.rollno = rollno;
    this.name = name;
  }
  @Override
  public String toString() {
    return "stu79{" +
            "rollno=" + rollno +
            ", name='" + name + '\'' +
            '}';
  }
}
class MyException2 extends RuntimeException
{
  MyException2(String str)
  {
    super(str);
  }
}

public class TestE {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/yyyy","root","");

    ArrayList<stu79>obj =  new ArrayList();
    Scanner s = new Scanner(System.in);

    
      stu79[] arr = new stu79[3];
      for (int i = 0; i <arr.length ; i++) {
        arr[i]= new stu79(s.nextInt(),s.next());
      }
      for (int j = 0; j < arr.length; j++) {
        try{
        if(arr[j].rollno==5)
        {
          throw new MyException2("invalid age ");
        }
        else{
          obj.add(arr[j]);
        }
      }

    catch(MyException2 e){
        e.printStackTrace();
      }
      }
    System.out.println(obj.size());
    System.out.println(obj);
      String str = "insert into stu values(?,?)";
    PreparedStatement ps = con.prepareStatement(str);
    for (int k = 0; k <obj.size() ; k++) {

      ps.setInt(1, obj.get(k).rollno);
      ps.setString(2, obj.get(k).name);
      ps.executeUpdate();
    }

  }
}
