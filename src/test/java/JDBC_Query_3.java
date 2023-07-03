import utilities.ReusableMethods;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Statement;
public class JDBC_Query_3 {
    public static void main(String[] args) throws SQLException {
  /*
   User tablosundaki hastalardan user_id'si 10'dan buyuk ve 15'den kucuk olanlarin
   username ve password bilgilerini yazdirin.
  */
Statement st= ReusableMethods.createStatement(ReusableMethods.getConnection());
String query="SELECT username,password FROM heallife_hospitaltraining.users WHERE user_id>10 AND user_id<15";

ResultSet rs=st.executeQuery(query);

while (rs.next()){
    System.out.println(rs.getString("username")+"- - "+rs.getString("password"));
       }
        System.out.println("----------------------------------");
  /*
  Transactions tablosundan Blood Bank'tan islem yapan hastalarin patiend_id ve
  amount bilgilerini kucukten buyuge göre siralayarak yazdiriniz.
   */
        Statement st1= ReusableMethods.createStatement(ReusableMethods.getConnection());
   String query1="SELECT patient_id, amount FROM heallife_hospitaltraining.transactions WHERE section ='Blood Bank' ORDER BY amount ASC";

       ResultSet rs1= st.executeQuery(query1);
        while (rs1.next()){
            System.out.println(rs1.getInt("patient_id")+"- - "+rs1.getInt("amount"));
        }
        rs.close();
        st.close();
    }
}
