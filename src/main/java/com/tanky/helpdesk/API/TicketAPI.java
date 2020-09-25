	package com.tanky.helpdesk.API;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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

import com.tanky.helpdesk.Entity.StatusEntity;
import com.tanky.helpdesk.Entity.TicketEntity;
import com.tanky.helpdesk.Entity.UserEntity;
import com.tanky.helpdesk.Service.StatusService;
import com.tanky.helpdesk.Service.TicketService;
import com.tanky.helpdesk.Service.UserService;
import com.tanky.helpdesk.Utils.FileUtils;

@RestController
@RequestMapping("/v1/ticket")
public class TicketAPI {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private FileUtils fileUtils;

	
	@GetMapping
	public ResponseEntity<List<TicketEntity>> getAll() throws Exception {
		return ResponseEntity.ok(ticketService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TicketEntity> getOneById(@PathVariable Long id) {
		return ResponseEntity.ok(ticketService.findOne(id));
	}
	
	@PostMapping
	public ResponseEntity<TicketEntity> save(@RequestBody TicketEntity ticketEntity) throws Exception {
		String URL = fileUtils.decoder(ticketEntity.getImage(), "outputFile");
		ticketEntity.setImage(URL);
		return ResponseEntity.ok(ticketService.save(ticketEntity));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TicketEntity> updateById(@PathVariable Long id, @RequestBody TicketEntity ticketEntity ) throws Exception {
		if (ticketService.findOne(id) != null) {
			ticketEntity.setId(id);
	
			return ResponseEntity.ok(ticketService.saveAndFlush(ticketEntity));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) throws Exception {
		ticketService.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
}
