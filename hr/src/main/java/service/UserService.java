package service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import entity.User;
import exception.NotFoundException;

@Service
public class UserService {
	
	private static int id = 0;
	private Map<Integer, User> users = new HashMap<Integer, User>();

	public User create(User u) {
		u.setId(++id);

		users.put(id, u);

		return u;
	}

	public User update(Integer id, User u) {

		var existing = get(id);

		existing.setName(u.getName());
		existing.setPassword(u.getPassword());
		existing.setEmail(u.getEmail());

		return existing;
	}

	public User get(Integer id) {

		var user = users.get(id);

		if (user == null) {
			throw new NotFoundException("User with ID " + id + " not found");
		}

		return user;
	}

	public List<User> getAll() {
		return new ArrayList<>(users.values());
	}

	public void delete(Integer id) {

		get(id);

		users.remove(id);
	}
}
