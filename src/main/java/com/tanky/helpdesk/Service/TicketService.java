package com.tanky.helpdesk.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanky.helpdesk.Entity.TicketEntity;
import com.tanky.helpdesk.Entity.UserEntity;
import com.tanky.helpdesk.Repository.TicketRepo;

@Service
public class TicketService {

	@Autowired
	private TicketRepo ticketRepo;
	
	public List<TicketEntity> findAll() {
		return ticketRepo.findAll();
	}
	
	public TicketEntity findOne(Long id) {
		return ticketRepo.findById(id).orElse(new TicketEntity());
	}
	
	public TicketEntity save(TicketEntity entity) {
		return ticketRepo.save(entity);
	}
	
	public void saveAll(List<TicketEntity> ticketEntities) {
		for (TicketEntity ticketEntity : ticketEntities) {
			ticketRepo.save(ticketEntity);
		}

	}
	
	public void delete(Long id) {
		TicketEntity ticketEntity = ticketRepo.findById(id).orElse(new TicketEntity());
		ticketEntity.getStatus().removeAll(ticketEntity.getStatus());
		ticketRepo.delete(ticketEntity);
	}
	
}
