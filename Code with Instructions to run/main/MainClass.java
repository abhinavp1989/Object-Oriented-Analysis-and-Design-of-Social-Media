//package main;
import dbconnection.MakeConnection;
import model.Account;
import model.IncidentTicket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;



public class MainClass {
	
	public static void main(String args[]) {

		Connection conn = null;
		conn = MakeConnection.getDafaultConnection();
		if (conn != null) {

			MainClass mainClass = new MainClass();

			// create database and tablespace

			mainClass.createTablespace(conn);

			conn = MakeConnection.getConnection("SocialMediaDB");

			// create tables
			mainClass.createTables(conn);
			
			//System.out.println("Abhinav");
			//Insert into table
			mainClass.insertValuesToTables(conn);
			
			//Update Tables
			mainClass.updateValuesToTables(conn);
			
			//Delete From Tables
			mainClass.deleteValuesToTables(conn);

			//Select From Table
			mainClass.selectValuesFromTable(conn);
			//System.out.println("Abhinav");
		

		} else {
			System.out.println("Driver is not connected");
		}
}



public void createTablespace(Connection conn) {

	// query
	String createDatabaseQuery = "CREATE DATABASE SocialMediaDB";
	String useDB = "USE SocialMediaDB";
	String createTablespaceCommand = "CREATE TABLESPACE SocialMediaDB ADD DATAFILE 'SocialMediaDB.ibd';";
	Statement statement = null;
	try {
		statement = conn.createStatement();
		statement.executeUpdate(createDatabaseQuery);
		statement.executeUpdate(useDB);
		 statement.executeUpdate(createTablespaceCommand);
	} catch (SQLException e) {
		e.printStackTrace();
	} finally 
	{
		try {
			statement.close();
		} catch (SQLException e) {
			System.out.println("\n------Please Check Error  for TableSpace Below-------\n");
			e.printStackTrace();
		}
	}
}

//Create Table

public void createTables(Connection conn) {
	Statement statement = null;
	try {
		statement = conn.createStatement();
		String createTableAccountQuery = "CREATE TABLE Account (Username VARCHAR(12) NOT NULL, Password VARCHAR(10) NOT NULL,"
				+ "Name VARCHAR(40) NOT NULL, Email VARCHAR(15) NOT NULL,phoneNumber INT(10), Gender VARCHAR(1), "
				+ "CONSTRAINT AccountPK PRIMARY KEY (Username));";

		statement.executeUpdate(createTableAccountQuery);
		System.out.println("\nTable Account Created Successfully\n");

		String createTableIncidentTicketQuery = "CREATE TABLE IncidentTicket (id INT(6) NOT NULL,inapuserid VARCHAR(12) NOT NULL, inappostid INT(6) NOT NULL, assignedTechnicianid INT(6) NOT NULL, date datetime(6), time time(3) , "
				+ "issue VARCHAR(12), "
				+ "CONSTRAINT IncidentTicketPK PRIMARY KEY (id));";

		statement.executeUpdate(createTableIncidentTicketQuery);
		System.out.println("\nTable Incident Created Successfully\n");

		
	} catch (Exception e) {
		System.out.println("\n------Please Check Error for Table creation Below---------\n");
		e.printStackTrace();
	}

}

//Create User -Comment the function if not needed(Created to test the user functionality)
/*public void createUsers(Connection conn) {
	// users query

	Statement statement = null;

	try {
		statement = conn.createStatement();

		String createDbAdminUserQuery = "CREATE USER 'Abhi'@'localhost' IDENTIFIED BY '987';";

		String grantDbAdminQuery = "GRANT ALL PRIVILEGES ON * . * TO 'Abhi'@'localhost'";

		statement.executeUpdate(createDbAdminUserQuery);
		statement.executeUpdate(grantDbAdminQuery);

		// Creating Technical Support Specialist  users
		statement.executeUpdate(this.formCreateUserQuery("Tom", "Tom"));
		statement.executeUpdate(this.formCreateUserQuery("Joe", "Joe"));

		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// statements to execute
}
*/
//Grant Permission to the users()
/*
public void grantPermission(Connection conn) {
	// grants queries

	Statement statement = null;
	try {

		statement = conn.createStatement();
		// grantTechnical Support

		statement.executeUpdate("GRANT CREATE ON TABLE SocialMediadb.incidentticket TO 'Tom'@'localhost'");
		statement.executeUpdate("GRANT ALTER ON TABLE SocialMediadb.incidentticket TO 'Tom'@'localhost'");
		statement.executeUpdate("GRANT DROP ON TABLE SocialMediadb.incidentticket TO 'Tom'@'localhost'");

		statement.executeUpdate("GRANT CREATE ON TABLE SocialMediadb.incidentticket TO 'Joe'@'localhost'");
		statement.executeUpdate("GRANT ALTER ON TABLE SocialMediadb.incidentticket TO 'Joe'@'localhost'");
		statement.executeUpdate("GRANT DROP ON TABLE SocialMediadb.incidentticket TO 'Joe'@'localhost'");

		
	} catch (Exception e) {
		e.printStackTrace();
	}
	// satements
}
*/

//Account Objects Creation
private List<Account> getAccountObjects() {
	List<Account> AccountObjectList = new ArrayList<Account>();

	Account AccountObject1 = new Account();
	AccountObject1.setUsername("ABC");
	AccountObject1.setPassword("123");
	AccountObject1.setEmail("harry@gmail.com");
	AccountObject1.setName("Harry");
	AccountObject1.setphoneNumber(1234567890);
	AccountObject1.setGender("M");
	

	Account AccountObject2 = new Account();
	AccountObject2.setUsername("XYZ");
	AccountObject2.setPassword("789");
	AccountObject2.setEmail("Cristine");
	AccountObject2.setName("mike@gmail.com");
	AccountObject2.setphoneNumber(1234675890);
	AccountObject2.setGender("F");
	
	AccountObjectList.add(AccountObject1);
	AccountObjectList.add(AccountObject2);

	return AccountObjectList;
}

//IncidentTicket Object creation
private List<IncidentTicket> getIncidentTicketObjects() {
	List<IncidentTicket> IncidentTicketObjectList = new ArrayList<IncidentTicket>();

	IncidentTicket IncidentTicketObject1 = new IncidentTicket();
	IncidentTicketObject1.setId(000001);

	IncidentTicketObject1.setInapuserid(123);
	IncidentTicketObject1.setInappostid(345);
	IncidentTicketObject1.setAssignedTechnicianid(567);
	IncidentTicketObject1.setDate("05/14/2017");
	IncidentTicketObject1.setTime("123045");
	IncidentTicketObject1.setIssue("InappPost");
	
	
	IncidentTicket IncidentTicketObject2 = new IncidentTicket();
	IncidentTicketObject2.setId(000002);

	IncidentTicketObject2.setInapuserid(234);
	IncidentTicketObject2.setInappostid(345);
	IncidentTicketObject2.setAssignedTechnicianid(567);
	IncidentTicketObject2.setDate("05/14/2017");
	IncidentTicketObject2.setTime("123545");
	IncidentTicketObject2.setIssue("InappPost");
	
	IncidentTicketObjectList.add(IncidentTicketObject1);
	IncidentTicketObjectList.add(IncidentTicketObject2);

	
	return IncidentTicketObjectList;
}

//Function for inserting values into mysql
public void insertValuesToTables(Connection conn) {
	// insert queries

	
	this.insertIntoAccountTables(conn);
	this.insertIntoIncidentTicketTables(conn);
	

	
}

//Function for updating values into mysql

public void updateValuesToTables(Connection conn) {
	// update queries
	
	this.updateAccountTables(conn);
	

	
}

//Function to delete values into mysql

public void deleteValuesToTables(Connection conn) {
	// delete queries

	
	this.deleteValuesAccountTables(conn);
	

	
}

//Function for reading values from mysql
public void selectValuesFromTable(Connection conn) {
	// select queries

	
	this.selectValuesIncidentTicketTables(conn);


	
}

//Insert Statement Syntax Creation for MySQL

private void insertIntoIncidentTicketTables(Connection conn) {

	PreparedStatement pst = null;
	String insertIntoIncidentTicketQuery = "INSERT INTO Incidentticket VALUES " + "(?, ?, ?, ?, ?, ?, ?);";

	try {

		for (IncidentTicket IncidentTicket : this.getIncidentTicketObjects()) {
			pst = conn.prepareStatement(insertIntoIncidentTicketQuery);
			pst.setInt(1, IncidentTicket.getId());
			pst.setInt(2, IncidentTicket.getInapuserid());
			pst.setInt(3, IncidentTicket.getInappostid());
			pst.setInt(4, IncidentTicket.getAssignedTechnicianid());
			pst.setString(5, IncidentTicket.getDate());
			pst.setString(6, IncidentTicket.getTime());
			pst.setNString(7, IncidentTicket.getIssue());

			pst.executeUpdate();
			System.out.println("\n\nRecords Inserted into IncidentTicket Table Successfully\n");

		}
		//System.out.println("Abhinav");
	} catch (SQLException e) {
		System.out.println("\n---------Please Check Error Below for inserting values into Incident Ticket Table---------\n");
		e.printStackTrace();
	}

}

private void insertIntoAccountTables(Connection conn) {

	PreparedStatement pst = null;
	
	String insertIntoAccountQuery = "INSERT INTO Account VALUES " + "(?, ?, ?, ?, ?, ?);";

	try {

		for (Account Account : this.getAccountObjects()) {
			pst = conn.prepareStatement(insertIntoAccountQuery);
			pst.setString(1, Account.getUsername());
			pst.setString(2, Account.getpassword());
			pst.setString(3, Account.getName());
			pst.setString(4, Account.getEmail());
			pst.setLong(5, Account.getphoneNumber());
			pst.setString(6, Account.getgender());

			pst.executeUpdate();
			

		}System.out.println("\n\nRecords Inserted into Account  Table Successfully\n");
		//System.out.println("Abhinav");
	} catch (SQLException e) {
		System.out.println("\n---------------Please Check Error Below for inserting values into Account Table------\n");
		e.printStackTrace();
	}

}

//Update Queries-We can also update by creating an account list and setting the attributes which needs to be updated thereby returning the objects 
//and Calling those object in this update function .Similar to insertIntoAccountTable Function mentioned above

//Update Statement Syntax Creation for MySQL

private void updateAccountTables(Connection conn) {

	PreparedStatement pst = null;
	String updateAccountQuery = "Update Account Set phoneNumber = ? " + "Where name = ?;";

	try {

			pst = conn.prepareStatement(updateAccountQuery);
			pst.setInt(1, 312483991);
			pst.setString(2, "Harry");
		
			pst.executeUpdate();
			System.out.println("\n\nRecords updated into Account Table Successfully\n");

		//System.out.println("Abhinav");
	} catch (SQLException e) {
		System.out.println("\n-----Please Check Error Below for updating Account Table------\n");
		e.printStackTrace();
	}

}

////Select Statement Syntax Creation for MySQL

private void selectValuesIncidentTicketTables(Connection conn) {

	PreparedStatement pst = null;
	String selectIncidentTicketQuery = "Select id, inapuserid,inappostid,issue FROM incidentticket WHERE assignedTechnicianid = ?";

	try {

	
			pst = conn.prepareStatement(selectIncidentTicketQuery);
			pst.setInt(1,567 );
			
			ResultSet r = pst.executeQuery();

			while (r.next()) {

				int id = r.getInt("id");
				int inapuserid = r.getInt("inapuserid");
				int inappostid = r.getInt("inappostid");
				String issue = r.getString("issue");

				System.out.println("id- " + id);
				System.out.println("inapuserid- " + inapuserid);
				System.out.println("inappostid- " + inappostid);
				System.out.println("issue- " + issue);

			}
		System.out.println("\n\nRecords selected from Incident Ticket Table Successfully\n");
		//System.out.println("Abhinav");
	} catch (SQLException e) {
		System.out.println("\n-----Please Check Error Below for selecting values from Incident Ticket Table--------\n");
		e.printStackTrace();
	}

}

//Delete Statement Syntax Creation for MySQL

private void deleteValuesAccountTables(Connection conn) {

	PreparedStatement pst = null;
	String deleteAccountQuery = "DELETE  FROM Account WHERE Name = ?;";

	try {

			pst = conn.prepareStatement(deleteAccountQuery);
			pst.setString(1, "Harry");
			

			pst.executeUpdate();
			System.out.println("\n\nRecords Deleted into Account Table Successfully\n");
		//System.out.println("Abhinav");
	} catch (SQLException e) {
		System.out.println("\nPlease Check Error Below\n");
		e.printStackTrace();
	}

}

String formCreateUserQuery(String userName, String password) {
	return "CREATE USER '" + userName + "'@'localhost' IDENTIFIED BY '" + password + "'";

}
}
