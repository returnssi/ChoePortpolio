package com.choe.portpolio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySQLConnectionTest {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/choeportpolio?serverTimezone=Asia/Seoul";
	static final String USERNAME = "root";
	static final String PASSWORD = "1234";
	
	@Test
	public void getMySQLConnectionTest() {
		Connection conn = null;
		Statement stmt = null;
		try {
			System.out.println("=====================MySQL CONNECTION TEST START=====================");
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			
			String sql = "SELECT notice_title, notice_content, notice_wrnick FROM notice";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String notice_title = rs.getString("notice_title");
				String notice_content = rs.getString("notice_content");
				String notice_wrnick = rs.getString("notice_wrnick");
				
				System.out.println("게시글 제목 : " + notice_title);
				System.out.println("게시글 내용 : " + notice_content);
				System.out.println("작성자 닉네임 : " + notice_wrnick);
				
				
				logger.info("notice_title : {}", notice_title);
				logger.info("notice_content : {}", notice_content);
				logger.info("notice_wrnick : {}", notice_wrnick);
				
				System.out.println(notice_title + "이건 메모리가 많이 잡아먹어요");
				
				
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("=====================MySQL CONNECTION TEST END=====================");
	}
}
