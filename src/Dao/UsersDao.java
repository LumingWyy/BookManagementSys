
package Dao;

import java.util.List;

import Entity.Users;



public interface UsersDao {
	public int addUser(Users u);

	public int delUser(int id);

	public int updateUser(Users u);

	public Users findUserById(int id);

	public List<Users> getAllUsers();

}