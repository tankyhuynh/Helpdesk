package com.tanky.helpdesk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tanky.helpdesk.Entity.StatusEntity;

@Repository
public interface StatusRepo extends JpaRepository<StatusEntity, Long>{

	
	
}
