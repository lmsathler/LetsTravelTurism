package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.UserDTO;
import entity.User;
import service.UserService;



@RestController
public class UserController {
	
private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users/{id}")
	public UserDTO getById(@PathVariable Integer id) {
		var user = userService.get(id);
		
		return new UserDTO(user);
	}
	
	@GetMapping("/users")
	public List<UserDTO> getAll() {
		var users = userService.getAll();
		
		var userDtos = new ArrayList<UserDTO>();
		
		for (var user: users) {
			userDtos.add(new UserDTO(user));
		}
		
		return userDtos;
	}
	
	@PostMapping("/users")
	public UserDTO create(@RequestBody UserDTO u) {
		var user = new User(u);
		
		user = userService.create(user);
		
		return new UserDTO(user);
	}
	
	@PutMapping("/users/{id}")
	public UserDTO update(@PathVariable Integer id, @RequestBody UserDTO u) {
		var user = new User(u);

		user = userService.update(id, user);
		
		return new UserDTO(user);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		userService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
