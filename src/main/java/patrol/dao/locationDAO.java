package patrol.dao;

/**
 * Author: FES
 * Date: 15 January 2023
 * Purpose: CSC584 Assignment 2
 * Student name:
 * Student id:
 */
 
import java.sql.*;       
import java.util.*;
import java.util.Date;

import patrol.connection.ConnectionManager;
import patrol.model.Location;



public class locationDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;
	private String locatianArea;
	private int locationId;
	private String locationAddress;
	
	
	//Complete addOrder() method
	/*public void addSchedule(scheduleModel bean) {
		
		scheduleId = bean.getScheduleId();
		patrolmanId = bean.getPatrolmanId();
		dateCreated = bean.getDateCreated();
		scheduleTime = bean.getScheduleTime();
		locationId = bean.getLocationId();
	

		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection(); 

			//create statement
						
			ps = con.prepareStatement("INSERT INTO schedule(scheduleId,patrolmanId,scheduleTime,dateCreated,locationId)VALUES(?,?,?,?,?)");
			ps.setString(1, scheduleId);
			ps.setString(2, patrolmanId);
			ps.setString(3, scheduleTime);
			ps.setString(4, dateCreated);
			ps.setString(5, locationId);
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");

			//close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();				
		}
	}*/
	
	public static List<Location> getLocationDetails() { 
		List<Location> locations = new ArrayList<Location>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM location BY locationId";

			
			//execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Location location2 = new Location();
				location2.setLocationId(rs.getInt("locationId"));
				location2.setLocationArea(rs.getString("locationArea"));
				location2.setLocationAddress(rs.getString("locationAddress"));
				locations.add(location2);
			}


			//close connection
			con.close();

		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		return locations; 
	}

	

}
