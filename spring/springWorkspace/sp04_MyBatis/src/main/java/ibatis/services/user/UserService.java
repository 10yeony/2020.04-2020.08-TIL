package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;
/*
 * 데이터 가공 레이어...
 * 가장 관련이 깊은 메소드는 SELECT
 * DELETE는 데이터 가공과 관련이 없음
 */
public interface UserService {
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
