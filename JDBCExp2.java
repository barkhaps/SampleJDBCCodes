package jbcbExamples;

import java.sql.*;
import java.util.*;

public class JDBCExp2 {
	
	public static Connection conn;
	public static PreparedStatement statement;
	
	public static void main(String args[]) {
		List<WorldCityPojo> cityDetails = new ArrayList<WorldCityPojo>();
		try {
			Class.forName(DataSource.jdbcDriver).newInstance();
			conn = DriverManager.getConnection(DataSource.urlWorld, DataSource.dbuserName, DataSource.dbpassword);
			statement = conn.prepareStatement(DataSource.cityDataQuery);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				WorldCityPojo pojo = new WorldCityPojo();
				pojo.setCityId(rs.getInt(1));
				pojo.setCityName(rs.getString(2));
				pojo.setCityCountryCode(rs.getString(3));
				pojo.setCityDistrict(rs.getString(4));
				pojo.setCityPopulation(rs.getLong(5));
				cityDetails.add(pojo);
			}
			for(WorldCityPojo wcp:cityDetails) {
				System.out.println("City Name and Population: " + wcp.getCityName() + "," + wcp.getCityPopulation());
			}
			conn.close();
			//System.out.println(cityDetails.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
