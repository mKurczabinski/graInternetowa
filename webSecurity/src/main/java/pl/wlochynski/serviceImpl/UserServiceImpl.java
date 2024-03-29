package pl.wlochynski.serviceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.wlochynski.models.Role;
import pl.wlochynski.models.User;
import pl.wlochynski.repository.RoleRepository;
import pl.wlochynski.repository.UserRepository;
import pl.wlochynski.service.UserService;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		
		Role role = roleRepository.findByRole("ROLE_ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(role)));
		
		userRepository.save(user);
		
	}
	
	@Override
	public void updateUserPassword(String newPassword, String email)
	{
		userRepository.updateUserPassword(bCryptPasswordEncoder.encode(newPassword), email);
	}

	@Override
	public void updateUserProfile(String newName, String newLastName, String newEmail, int id) {
		userRepository.updateUserProfile(newName, newLastName, newEmail, id);
		
	}

	@Override
	public List<User> findAll() {
		List<User> userList = userRepository.findAll();
		return userList;
	}
}
