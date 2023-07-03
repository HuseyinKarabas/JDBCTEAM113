import java.sql.*;
public class JDBC_Query_2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                                                    "root",
                                                    "1234");
        Statement st= con.createStatement();

        /*
        ORNEK1: Id'si 1'den buyuk firmaların ismini ve iletisim_isim'ini isim ters sirali yazdirin.
         */

        String selectQuery="SELECT isim, iletisim_isim " +
                          "FROM firmalar "+
                          "WHERE id>1 "+
                          "ORDER BY isim DESC";
        String selectQuery2="SELECT isim, iletisim_isim FROM firmalar WHERE id>1 ORDER BY isim DESC";
        ResultSet data=st.executeQuery(selectQuery);

        while (data.next()){
            System.out.println(data.getString("isim")+" "+data.getString("iletisim_isim"));
        }
         /*
        ORNEK2: Iletisim isminde 'li' iceren firmalarin id'lerini ve isim'ini id sirali yazdirin.
         */
        String selectQuery3="SELECT id, isim FROM firmalar WHERE iletisim_isim LIKE '%li%' ORDER BY id";
        ResultSet data2=st.executeQuery(selectQuery3);
        while (data2.next()){
            System.out.println(data2.getInt("id")+" "+data2.getString("isim"));
        }
        /*
        NOT1:Sorgulama icin get ile istenirse sütun (field) ismini yazabilecegemiz gibi sutun index
        (field olusturulma sirasina gore) yazilabilir.
         */
        /*
        NOT2: Sorgumuzda SELECT'TEN sonra sadece belli fieldlari dondurmesini istiyorsak
        get ile cagirdigimiz field indexleri sorguda belirttigimiz sirayla ifade etmemiz gerekiyor
         */


    }
}
