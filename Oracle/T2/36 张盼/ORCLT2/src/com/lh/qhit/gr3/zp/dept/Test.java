/**
 * 
 */
package com.lh.qhit.gr3.zp.dept;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.sun.corba.se.pept.transport.Connection;

/**
 * @author 张盼
 *  TODO下午12:07:55
 */
public class Test {
	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String nam="sys as sysdba";
			String pwd="sys";
			Connection con=(Connection) DriverManager.getConnection(url,nam,pwd);
			Statement st=(Statement) ((java.sql.Connection) con).createStatement();
			String sql="select * from dept";
			ResultSet rs=((java.sql.Statement) st).executeQuery(sql);
			while(rs.next()){
				System.out.print(rs.getInt("did")+"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.print(rs.getString("tel")+"\t");
				System.out.println(rs.getString("ress"));
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
	}
}
