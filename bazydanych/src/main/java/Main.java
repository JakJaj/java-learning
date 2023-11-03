import java.sql.*;

public class Main {
    public static final String DB_NAME = "identifier.sqlite";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    "("+ COLUMN_NAME +" TEXT," +
                    COLUMN_PHONE + " INTEGER," +
                    COLUMN_EMAIL +" TEXT)");

            insertContacts(statement,"Jakub",403203032,"jakub@gmail.com");
            insertContacts(statement,"Ewa",403201503,"ewa@gmail.com");
            insertContacts(statement,"Adam",403203050,"adam@gmail.com");

            ResultSet result = statement.executeQuery("SELECT * from " + TABLE_CONTACTS);

            while (result.next()){
                System.out.println(result.getString(COLUMN_NAME) + " " + result.getInt(COLUMN_PHONE) + " " + result.getString(COLUMN_EMAIL));
            }
            conn.commit();

            result.close();
            statement.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

    }
    public static void insertContacts(Statement statement,String name, int phone, String email) throws SQLException{
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " VALUES('" + name + "'," + phone +",'"  + email +"')");
    }
}
