package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Adeola.Ojo on 7/17/2016.
 */
public class DaoUtil {

    //my connection
    private static Connection mysqlConnection;

    /**
     * mySqlConnection
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static Connection getMySqlConnection() throws ClassNotFoundException, SQLException {
        if (mysqlConnection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uat_autopay", "root", "root");
        }
        return mysqlConnection;
    }

    public static List<AutogateProcessor> getAutogateProcessors() throws SQLException, ClassNotFoundException {
        Connection conn = getMySqlConnection();
        return null;
    }

}
