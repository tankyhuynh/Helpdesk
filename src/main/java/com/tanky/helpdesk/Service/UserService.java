package com.tanky.helpdesk.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanky.helpdesk.Entity.TicketEntity;
import com.tanky.helpdesk.Entity.UserEntity;
import com.tanky.helpdesk.Repository.TicketRepo;
import com.tanky.helpdesk.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public List<UserEntity> findAll() {
		return userRepo.findAll();
	}
	
	public UserEntity findOne(Long id) {
		return userRepo.findById(id).orElse(new UserEntity());
	}
	
	public UserEntity findOneByUsernameAndPassword(String username, String password) {
		return userRepo.findOneByUsernameAndPassword(username, password);
	}
	
	public UserEntity save(UserEntity entity) {
		return userRepo.save(entity);
	}
	
	public void saveAll(List<UserEntity> userEntities) {
		for (UserEntity userEntity : userEntities) {
			userRepo.save(userEntity);
		}

	}
	
	public void delete(Long id) {
		UserEntity userEntity = userRepo.findById(id).orElse(new UserEntity());
		userEntity.getTickets().removeAll(userEntity.getTickets());
		userRepo.delete(userEntity);
	}
	
}
