package com.globalin.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.common.JDBCUtil;
import com.globalin.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	// JDBC 관련 변수 선언
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// sql 명령어들
	private String USER_GET = "select * from users where id=? and password=?";
	private String USER_INSERT = "insert into users(id, password, name, role) values(?,?,?,?)";
	private String USER_UPDATE = "update users set password=?, name=?, role=? where id=?";
	private String USER_DELETE = "delete from users where id=?";
	private String USER_LIST = "select * from users order by id desc";

	// CRUD 기능 메소드 구현

	public UserVO getUser(UserVO vo) {
		System.out.println("=====>JDBC로 getUser() 기능 처리");
		UserVO user = null;

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());

			rs = stmt.executeQuery();

			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return user;
	}

	public void insertUser(UserVO vo) {
		System.out.println("=====>JDBC로 insertUser() 기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	public void updateUser(UserVO vo) {
		System.out.println("=====>JDBC로 updateUser() 기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getPassword());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getRole());
			stmt.setString(4, vo.getId());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	public void deleteUser(UserVO vo) {
		System.out.println("=====>JDBC로 deleteUser() 기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	public List<UserVO> getUserList() {
		System.out.println("=====>JDBC로 getUserList() 기능 처리");
		List<UserVO> userList = new ArrayList<UserVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();

			UserVO user = null;

			while (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return userList;
	}

}