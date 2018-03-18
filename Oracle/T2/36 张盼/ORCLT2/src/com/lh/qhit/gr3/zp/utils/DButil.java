/**
 * 
 */
package com.lh.qhit.gr3.zp.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.corba.se.pept.transport.Connection;

/**
 * @author 张盼
 *  TODO上午10:01:27
 */
public class DButil {
	private static String ODriver= "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String user = "sys as sysdba";
	private static String password = "123456";
	public static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName(ODriver);
			con = (Connection) DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;

	}
}