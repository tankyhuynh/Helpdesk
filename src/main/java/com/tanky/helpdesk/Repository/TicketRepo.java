package com.tanky.helpdesk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tanky.helpdesk.Entity.TicketEntity;

@Repository
public interface TicketRepo extends JpaRepository<TicketEntity, Long> {

	
	
}
