package jbcbExamples;

import java.sql.*;
import java.util.*;
import java.io.*;

public class InsertJDBCExp {
	
	public static Connection conn;
	public static PreparedStatement statement;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Class.forName(DataSource.jdbcDriver).newInstance();
			conn = DriverManager.getConnection(DataSource.urlH2H, DataSource.dbuserName, DataSource.dbpassword);
			statement = conn.prepareStatement(DataSource.studentInsertQuery);
			for (int i = 0; i < 2; i++) {
				System.out.print("Enter RollNumber to insert: ");
				int roll = Integer.parseInt(br.readLine());
				statement.setInt(1, roll);
				System.out.print("Enter Name to insert: ");
				String name = br.readLine();
				statement.setString(2, name);
				statement.addBatch();
			}
			statement.executeBatch();
			System.out.println("Execution Complete");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
