package com.tanky.helpdesk.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanky.helpdesk.Entity.FAQEntity;
import com.tanky.helpdesk.Entity.StatusEntity;
import com.tanky.helpdesk.Entity.TicketEntity;
import com.tanky.helpdesk.Repository.StatusRepo;

@Service
public class StatusService {

	@Autowired
	private StatusRepo statusRepo;
	
	public List<StatusEntity> findAll() {
		return statusRepo.findAll();
	}
	
	public StatusEntity findOne(Long id) {
		return statusRepo.findById(id).orElse(new StatusEntity());
	}
	
	public StatusEntity save(StatusEntity entity) {
		return statusRepo.save(entity);
	}
	
	public void saveAll(List<StatusEntity> statusEntity) {
		for (StatusEntity statu : statusEntity) {
			statusRepo.save(statu);
		}

	}
	
	public void delete(Long id) {
		statusRepo.deleteById(id);
	}
	
}
