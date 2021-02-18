package jbcbExamples;

public class DataSource {
	public static String dbuserName = "root";
	public static String dbpassword = "root";
	public static String jdbcDriver = "com.mysql.jdbc.Driver";
	public static String urlWorld = "jdbc:mysql://localhost:3306/world";
	public static String urlH2H = "jdbc:mysql://localhost:3306/h2h";	
	
	public static String cityDataQuery = "select * from city";
	public static String studentInsertQuery = "insert into students (roll_number,student_name) values (?,?);";
}
