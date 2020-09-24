package com.tanky.helpdesk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tanky.helpdesk.Entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{

	UserEntity findOneByUsernameAndPassword(String username, String password);
	
}
