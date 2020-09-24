package com.tanky.helpdesk.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanky.helpdesk.Entity.TicketEntity;
import com.tanky.helpdesk.Service.TicketService;
import com.tanky.helpdesk.Utils.FileUtils;

@RestController
@RequestMapping("/v1/ticket")
public class TicketAPI {

	@Autowired
	private TicketService ticketSerivice;
	
	@Autowired
	private FileUtils fileUtils;

	
	@GetMapping
	public ResponseEntity<List<TicketEntity>> getAll() throws Exception {
		return ResponseEntity.ok(ticketSerivice.findAll());
	}
	
	@PostMapping
	public ResponseEntity<TicketEntity> save(@RequestBody TicketEntity ticketEntity) throws Exception {
		String URL = fileUtils.decoder(ticketEntity.getImage(), "outputFile");
		ticketEntity.setImage(URL);
		return ResponseEntity.ok(ticketSerivice.save(ticketEntity));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TicketEntity> update(@PathVariable Long id, @RequestBody TicketEntity ticketEntity ) throws Exception {
		ticketEntity.setId(id);
		return ResponseEntity.ok(ticketSerivice.save(ticketEntity));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) throws Exception {
		ticketSerivice.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
}
