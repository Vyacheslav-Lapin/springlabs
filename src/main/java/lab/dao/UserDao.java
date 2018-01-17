package lab.dao;

import java.util.List;

import lab.model.User;


public interface UserDao {
	
	void insert(User user);
	
	List<User> selectAll();

	default User select(int id) {
		return selectAll().stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElseThrow(UserNotFoundException::new);
	}

}

