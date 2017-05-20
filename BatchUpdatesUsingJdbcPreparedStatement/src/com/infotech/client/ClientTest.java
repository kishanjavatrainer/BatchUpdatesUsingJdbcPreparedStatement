package com.infotech.client;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.infotech.util.DBUtil;

public class ClientTest {

	public static void main(String[] args) {
		String UPDATESQL="UPDATE employee_table set salary=? WHERE employee_id=?";
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement ps= connection.prepareStatement(UPDATESQL)) {
			
			ps.setDouble(1, 70000.00);
			ps.setInt(2, 1);
			
			ps.addBatch();
			
			ps.setDouble(1, 95000.00);
			ps.setInt(2, 2);
			
			ps.addBatch();
			
			ps.setDouble(1, 75000.00);
			ps.setInt(2, 20);
			
			ps.addBatch();
			
			int[] executeBatch = ps.executeBatch();
			for (int i : executeBatch) {
				System.out.println(i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
