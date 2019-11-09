package pl.wlochynski.service;

import java.util.List;

import pl.wlochynski.models.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public void updateUserPassword(String newPassword, String email);
	public void updateUserProfile(String newName, String newLastName, String newEmail, int id);
	public List<User> findAll();
}
