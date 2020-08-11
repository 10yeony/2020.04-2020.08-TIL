package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {
	Connection getConnection() throws SQLException ;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException ;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException ;
	
	void registerUser(UserVO vo) throws SQLException;
	ArrayList<UserVO> showAllUser() throws SQLException;
	UserVO findByIdUser(String id) throws SQLException;	
	public UserVO login(String userId, String password) throws SQLException;
}
