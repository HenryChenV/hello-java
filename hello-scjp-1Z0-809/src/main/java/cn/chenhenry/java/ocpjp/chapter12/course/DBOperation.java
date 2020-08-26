package cn.chenhenry.java.ocpjp.chapter12.course;


import javax.swing.plaf.nimbus.State;
import java.sql.*;

class DBConnector {
    public static Connection connectToDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String database = "addressBook";
        String userName = "root";
        String password = "root";
        return DriverManager.getConnection(url + database, userName, password);
    }
}


/**
SQL:
CREATE TABLE `contact` (
     `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
     `firstName` VARCHAR(64) NOT NULL DEFAULT "",
     `lastName` VARCHAR(64) NOT NULL DEFAULT "",
     `email` VARCHAR(64) NOT NULL DEFAULT "",
     `phoneNo` VARCHAR(64) NOT NULL DEFAULT "",
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 INSERT INTO `contact`
    (`firstName`, `lastName`, `email`, `phoneNo`)
 VALUES
    ("Michael", "Taylor", "michael@abc.com", "+919876543210"),
    ("William", "Becker", "william@abc.com", "+449876543210");
 */
class DBQuery {
    public static void printResultSetWithName(ResultSet resultSet) throws SQLException {
        System.out.println("ID \tfName \tlName \temail \t\t\t\tphoneNo");
        while (resultSet.next()) {
            System.out.println(
                    resultSet.getInt("id") + "\t"
                            + resultSet.getString("firstName") + "\t"
                            + resultSet.getString("lastName") + "\t"
                            + resultSet.getString("email") + "\t\t"
                            + resultSet.getString("phoneNo")
            );
        }
    }

    public static void printResultSetWithIndex(ResultSet resultSet) throws SQLException {
        int numOfColumns = resultSet.getMetaData().getColumnCount();
        resultSet.beforeFirst();
        while (resultSet.next()) {
            for (int i = 1; i < numOfColumns; i++) {
                System.out.print(resultSet.getObject(i) + "\t");
            }
        }

    }

    public static void main(String[] args) {
        try (Connection connection = DBConnector.connectToDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * FROM contact")) {

            printResultSetWithName(resultSet);

            printResultSetWithIndex(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}


class DBUpdate {
    public static void main(String[] args) {
        try (Connection connection = DBConnector.connectToDB();
             Statement statement = connection.createStatement(
                     ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(
                     "SELECT * FROM `contact` WHERE firstName=\"Michael\"")) {
            System.out.println("Before the update");
            DBQuery.printResultSetWithName(resultSet);

            resultSet.absolute(1);
            resultSet.updateString("phoneNo", "+919976543210");
            resultSet.updateRow();

            System.out.println("After the update");
            resultSet.beforeFirst();
            DBQuery.printResultSetWithName(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


class DBInsert {
    public static void main(String[] args) {
        try (Connection connection = DBConnector.connectToDB();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT  * FROM contact")) {
            System.out.println("Before the insert");
            DBQuery.printResultSetWithName(resultSet);

            resultSet.moveToInsertRow();
            resultSet.updateString("firstName", "John");
            resultSet.updateString("lastName", "K.");
            resultSet.updateString("email", "john@abc.com");
            resultSet.updateString("phoneNo", "+19753186420");
            resultSet.insertRow();

            System.out.println("After the insert");
            resultSet.beforeFirst();
            DBQuery.printResultSetWithName(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


class DBDelete {
    public static void main(String[] args) {
        try (Connection connection = DBConnector.connectToDB();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM contact WHERE firstName=\"John\"")) {
            System.out.println("Before the deletion");
            DBQuery.printResultSetWithName(resultSet1);

            resultSet1.beforeFirst();
            if (resultSet1.next()) {
                resultSet1.deleteRow();
            }
            resultSet1.close();

            try (ResultSet resultset2 = statement.executeQuery("SELECT * FROM contact")) {
                System.out.println("After the deletion");
                DBQuery.printResultSetWithName(resultset2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


class DBCreateTable {
    public static void main(String[] args) {
        try (Connection connection = DBConnector.connectToDB();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "CREATE TABLE familyGroup (" +
                    "id int not null auto_increment, " +
                    "nickName varchar(30) not null, " +
                    "primary key(id)" +
                    ");"
            );
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


public class DBOperation {

}
