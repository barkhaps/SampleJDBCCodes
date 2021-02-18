package jbcbExamples;

import java.sql.*;
import java.io.*;

public class JDBCExp {
	public static Connection conn;
	public static String dbuserName = "root";
	public static String dbpassword = "root";
	public static String jdbcDriver = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/world";
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Class.forName(jdbcDriver).newInstance();
			conn = DriverManager.getConnection(url, dbuserName, dbpassword);
			String selectQuery = "SELECT COUNT(*) FROM country WHERE Continent = 'Asia'";
			String updateQuery = "UPDATE country SET SurfaceArea = 193.23 WHERE Name = 'Aruba'";
			String insertQuery = "insert into `world`.`country` (`Code`, `Name`, `Continent`, `Region`, `SurfaceArea`, "
					+ "`IndepYear`, `Population`, `LifeExpectancy`, `GNP`, `GNPOld`, `LocalName`, `GovernmentForm`, "
					+ "`HeadOfState`, `Capital`, `Code2`, `new_col`) values ('SMT', 'Something', 'Asia', "
					+ "'Somewhere', '1000.00', '1900', '10000', '80.5', '10000.00', '10000.00', 'Something', "
					+ "'Something', 'Someone', '1234', 'SM', NULL);";
			String paramSelectQuery = "Select * FROM country WHERE Continent = ?"; 
			
			//TO PERFORM SELECT
			/*PreparedStatement statement=conn.prepareStatement(selectQuery);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(2));
				System.out.println(rs.getString("Continent"));
			}
			System.out.print(statement);*/
			
			/*PreparedStatement statement=conn.prepareStatement(selectQuery);
			ResultSet rs = statement.executeQuery();
			//rs.last();
			//System.out.println(rs.getInt(1));
			rs.first();
			System.out.println(rs.getInt(1));
//			if(rs.next()) {
//				System.out.println(rs.getInt(1));
//			}
*/			
			
			//TO PERFORM UPDATE
			/*PreparedStatement statement1=conn.prepareStatement(updateQuery);
			int rowsUpdated = statement1.executeUpdate();
			System.out.println("Rows Updated: "+rowsUpdated);*/
			
			//TO PERFORM INSERT
			/*PreparedStatement statement2=conn.prepareStatement(insertQuery);
			statement2.executeUpdate();
			System.out.println("Execution successful, Row added");*/
			
			//TO PERFORM SELECT WITH PARAMETERS
			System.out.print("Enter the Continent name to get countries: ");
			String parameter = br.readLine();
			PreparedStatement statement3 = conn.prepareStatement(paramSelectQuery);
			System.out.println(statement3);
			statement3.setString(1, parameter);
			System.out.println(statement3);
			ResultSet rs1 = statement3.executeQuery();
			while(rs1.next()) {
				System.out.println(rs1.getString(2));
			}
			
			conn.close();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
