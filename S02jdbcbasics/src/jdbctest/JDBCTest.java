package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		
//		Connection con = null;
//		Statement st = null;
		InsertintoDB();
		
		updateDB();
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
				Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("Select * from account");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getInt(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

	private static void updateDB() {
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
				Statement st = con.createStatement();) {
			int rowsupdated = st.executeUpdate("update account set balance=19009 where accon = 1");
			System.out.println("Number of rows inserted"+rowsupdated);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	private static void InsertintoDB() {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
				Statement st = con.createStatement();) {
			int rowsinserted = st.executeUpdate("insert into account values(2,'ranji','ar',10000)");
			System.out.println("Number of rows inserted"+rowsinserted);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
