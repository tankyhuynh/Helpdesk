package com.tanky.helpdesk.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanky.helpdesk.Entity.UserEntity;
import com.tanky.helpdesk.Service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserAPI {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAll() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getOneById(Long id) {
		return ResponseEntity.ok(userService.findOne(id));
	}
	
	@PostMapping
	public ResponseEntity<UserEntity> save(@RequestBody UserEntity userEntity) {
		return ResponseEntity.ok(userService.save(userEntity));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateById(@PathVariable Long id, @RequestBody UserEntity userEntity) {
		if ((userService.findOne(id)) != null) {
			userEntity.setId(id);
			return ResponseEntity.ok(userService.save(userEntity));
		}
		else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		 userService.delete(id);
	}
	
	
	
	
	
	
}
