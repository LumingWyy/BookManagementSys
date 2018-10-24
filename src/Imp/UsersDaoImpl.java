package Imp;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.BaseDao;
import Dao.UsersDao;
import Entity.Users;

 
public class UsersDaoImpl extends BaseDao implements UsersDao {
 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
 
	@Override
	public int addUser(Users u) {
		int num = 0;
		String sql = "insert into users(name,email) values(?,?)";
		try {
			num = executeUpdate(sql, u.getName(), u.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
 
	@Override
	public int delUser(int id) {
		int num = 0;
		String sql = "delete from users where id=?";
		try {
			num = executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
 
	@Override
	public int updateUser(Users u) {
		int num = 0;
		String sql = "update users set name=?,email=? where id=?";
		try {
			num = executeUpdate(sql, u.getName(), u.getEmail(), u.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
 
	@Override
	public Users findUserById(int id) {
		Users u = null;
		String sql = "select * from users where id=?";
		rs = executeQuery(sql, id);
		try {
			if (rs.next()) {
				u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
 
	@Override
	public List<Users> getAllUsers() {
		List<Users> ulist = new ArrayList<Users>();
		String sql = "select * from users";
		rs = executeQuery(sql);
		try {
			while (rs.next()) {
				Users u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3));
				ulist.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ulist;
	}
 
}
