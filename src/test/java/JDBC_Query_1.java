import java.sql.*;
public class JDBC_Query_1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      // 1-> Ilgili Driver'i yuklemeliyiz. MySQL kullandigimizi bildiriyoruz. Kullanilacak veritabani icin dogru surucuyu ekle
        //Driver'i bulamam ihtimaline karsi forName methodu icin ClassNotFoundException method signature'imiza exception olarak firlatmamizi istiyor.

            Class.forName("com.mysql.cj.jdbc.Driver");
      // 2-> Database baglantisi kurulur. Baglantiyi olusturmak icin username ve password girmeliyiz.
        //Burada bu username ve passwordun yanlıs olma ihtimaline karsi SQLException firlatmamizi istiyor.

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                                                    "root",
                                                    "1234");
        /*
        Olusturulan connection bir objeye atnamasa da calisir,
        ancak ileride ilgili connection'i kullanmak istersek ona ulaşamayız.
        o yuzden onu Connection nesnesine atama yapariz
         */

        // 3->SQl query'leri icin bir Statement objesi olusturup, javada SQL sorgularimiz icin bir alan acacagiz.  SQL sorgularini yapabilmek icin suite hazirla
        Statement st= con.createStatement();

        // 4-> SQL sorgularini hazirla ve calistir.
        ResultSet query=st.executeQuery("SELECT*FROM personel");

        //5-Sonuclari gormak icin Iteration ile Set icerisindeki elemanlari while dongusu ile yazdiriyoruz.
        while (query.next()){
            System.out.println(query.getInt(1)+" "+ query.getString(2)
                                 +" "+query.getString(3)+" "+query.getInt(4)+" "+query.getString(5));
        }
       //6-Olusturulan baglantilari kapatiyoruz.
        con.close();
        st.close();
        query.close();
    }
}
