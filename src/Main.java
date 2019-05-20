import java.sql.*;

public class Main {

    private final static String url = "jdbc:postgresql://localhost:5432/2019-05-21-CW-AM";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

            ex1(conn);
            ex2(conn);
            ex3(conn);
            ex4(conn);
            ex5(conn);
            ex6(conn);
            ex7(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

        return conn;
    }

//    1. Create a new Los Angeles entry for Papers with any code that cost 90.1.

    private static void ex1(Connection conn){
        try {

            String SQL = "INSERT INTO Warehouses(Code,Location,Capacity) VALUES(9,'Los Angeles',7);";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                System.out.println(rs.getString("contents"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

    }

//    2. Select the warehouse code and the average value of the boxes in each warehouse.

    private static void ex2(Connection conn){
        try {

            String SQL = "SELECT warehouses.code, avg(value) " +
                    "from warehouses " +
                    "JOIN boxes on warehouses.code = boxes.warehouse " +
                    "group by warehouses.code";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                System.out.println(rs.getString("contents"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

    }

//    3. Select the warehouse code and the average value of the boxes in each warehouse, but select only those warehouses where the average value of the boxes is greater than 150.


    private static void ex3(Connection conn){
        try {

            String SQL = "SELECT warehouses.code, avg(value) " +
                    "from warehouses " +
                    "JOIN boxes on warehouses.code = boxes.warehouse " +
                    "where value >150";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                System.out.println(rs.getString("contents"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

    }

//    4. Find all values per each content in the Boxes table.


    private static void ex4(Connection conn){
        try {

            String SQL = "SELECT value FROM boxes group by contents";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                System.out.println(rs.getString("contents"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

    }

//    5. Find the total value of all boxes.


    private static void ex5(Connection conn){
        try {

            String SQL = "SELECT avg(value) FROM boxes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                System.out.println(rs.getString("contents"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

    }

//    6. Reduce the value of all boxes by 15%.


    private static void ex6(Connection conn){
        try {

            String SQL = "update boxes set boxes.value = value*.85";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                System.out.println(rs.getString("value"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

    }

//    7. Remove all boxes with a value lower than $100.


    private static void ex7(Connection conn){
        try {

            String SQL = "DELETE from boxes where boxes.value = value <100 ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                System.out.println(rs.getString("contents"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        connect();

    }
}
