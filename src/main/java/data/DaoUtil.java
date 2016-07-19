package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Adeola.Ojo on 7/17/2016.
 */
public class DaoUtil {

    private static String dbUsername;
    private static String dbPassword;
    private static final String uspGetAutogateProcessors = "{call uspGetAutogateProcessors()}";
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

    /**
     * get Autogate Processors
     *
     * @param props
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<AutogateProcessor> getAutogateProcessors(Map<String, String> props) throws SQLException, ClassNotFoundException {

        Connection conn = getMySqlConnection();
        CallableStatement query = conn.prepareCall(uspGetAutogateProcessors);
        ResultSet result = query.executeQuery();
        List<AutogateProcessor> processorList = new ArrayList<AutogateProcessor>();

        while (result.next()) {
            try {
                AutogateProcessor proc = new AutogateProcessor();
                proc.setId(result.getInt("id"));
                proc.setBankId(result.getInt("bankid"));
                proc.setDescription(result.getString("description"));
                proc.setSpeed(result.getInt("speed"));
                proc.setStp(result.getBoolean("isstp"));
                processorList.add(proc);
            } catch (Exception exc) {

            }
        }
        return processorList;
    }

}
