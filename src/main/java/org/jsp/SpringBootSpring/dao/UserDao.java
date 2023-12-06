package org.jsp.SpringBootSpring.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootSpring.dto.User;
import org.jsp.SpringBootSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public Optional<User> findUserByid(int id) {
		return userRepository.findById(id);
	}

	public boolean deleteUser(int id) {
		Optional<User> db = findUserByid(id);
		if (db.isPresent()) {
			userRepository.delete(db.get());
			return true;
		}
		return false;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> verifyUser(long phone, String password) {
		return userRepository.verifyUser(phone, password);
	}

	public Optional<User> verifyUser(String email, String password) {
		return userRepository.verifyUser(email, password);
	}

	public Optional<User> verifyUser(int id, String email) {
		return userRepository.verifyUser(id, email);
	}

	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}

	public User findByPhone(long phone) {
		return userRepository.findByPhone(phone);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<User> findByAge(int age) {
		return userRepository.findByAge(age);
	}

}
