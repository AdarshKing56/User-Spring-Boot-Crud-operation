package org.jsp.SpringBootSpring.service;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootSpring.dao.UserDao;
import org.jsp.SpringBootSpring.dto.ResponseStructure;
import org.jsp.SpringBootSpring.dto.User;
import org.jsp.SpringBootSpring.exception.IdNotFoundException;
import org.jsp.SpringBootSpring.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	ResponseStructure<User> structure = new ResponseStructure<>();


	public ResponseEntity<ResponseStructure<User>> saveUser( User user) {
		structure.setMessage("User saved successfully");
		structure.setData(userDao.saveUser(user));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}


	public ResponseEntity<ResponseStructure<User>> updateUser( User user) {
		structure.setMessage("User updated successfully");
		structure.setData(userDao.updateUser(user));
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}

	
	public ResponseEntity<ResponseStructure<User>> findUserById( int id) {
		Optional<User> db = userDao.findUserByid(id);
		if (db.isPresent()) {
			structure.setMessage("User found");
			structure.setData(db.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();

	}

	
	public ResponseEntity<ResponseStructure<List<User>>> findAlluser(User user) {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setMessage("List of all Users");
		structure.setData(userDao.findAll());
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
	}

	
	public ResponseEntity<ResponseStructure<User>> deleteUser( int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<User> db = userDao.findUserByid(id);
		if (db.isPresent()) {
			userDao.deleteUser(id);
			structure.setMessage("User deleted");
			structure.setData("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
		   return new ResponseEntity<ResponseStructure<User>>(HttpStatus.OK);
		}
		structure.setMessage("User Not  deleted");
		structure.setData("User Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password){
		Optional<User> db=userDao.verifyUser(phone, password);
		if(db.isPresent()) {
			structure.setMessage("Verification successfull");
			structure.setData(db.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(int id,String password){
		Optional<User> db=userDao.verifyUser(id, password);
		if(db.isPresent()) {
			structure.setData(db.get());
			structure.setMessage("Verification successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password){
		Optional<User> db=userDao.verifyUser(email,password);
		if(db.isPresent()) {
			structure.setData(db.get());
			structure.setMessage("Verification successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> findByName(String name){
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		structure.setMessage("List of All user by name");
		structure.setData(userDao.findByName(name));
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
		
	}



}
