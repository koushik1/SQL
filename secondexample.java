
import java.sql.*;


public class secondexample {

    static final String jdbcURL 
	= "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";

    public static void main(String[] args) {
        try {

// Load the driver. This creates an instance of the driver
// and calls the registerDriver method to make Oracle Thin
// driver available to clients.

//  Class.forName("oracle.jdbc.driver.OracleDriver"); older


         Class.forName("oracle.jdbc.OracleDriver");

	    String user = "kshanka2";	// For example, "jsmith"
	    String passwd = "200314081";	// Your 9 digit student ID number


            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {

		// Get a connection from the first driver in the
		// DriverManager list that recognizes the URL jdbcURL

		conn = DriverManager.getConnection(jdbcURL, user, passwd);

		// Create a statement object that will be sending your
		// SQL statements to the DBMS

		stmt = conn.createStatement();

		// Create the COFFEES table

        stmt.executeUpdate("ALTER TABLE COFFEES1 " +
                "ADD CONSTRAINT coffee_pk "+
			   "PRIMARY KEY (SUP_ID)");


            } finally {
                close(rs);
                close(stmt);
                close(conn);
            }
        } catch(Throwable oops) {
            oops.printStackTrace();
        }
    }

    static void close(Connection conn) {
        if(conn != null) {
            try { conn.close(); } catch(Throwable whatever) {}
        }
    }

    static void close(Statement st) {
        if(st != null) {
            try { st.close(); } catch(Throwable whatever) {}
        }
    }

    static void close(ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch(Throwable whatever) {}
        }
    }
}



