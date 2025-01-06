package com.Jira.Application.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jira.Application.Entity.Ticket;
import com.Jira.Application.Service.TicketService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/tickets")
public class TicketController {
  
	@Autowired
	private TicketService ticketService;
	
	public List<Ticket>getAllTickets(){
		return ticketService.getAllTickets();
	}
	@PostMapping("/{projectId}")
	public ResponseEntity<Ticket>saveTicket(@RequestBody Ticket ticket,@PathVariable Long projectId){
		Ticket savedTicket = ticketService.saveTicket(ticket, projectId);
		return new ResponseEntity<Ticket>(savedTicket,HttpStatus.CREATED);
	}
	@GetMapping("/{projectId}")
	public ResponseEntity<List<Ticket>>getAllTicketsByProjectId(@PathVariable Long projectId){
		List<Ticket> tickets = ticketService.getAllTicketsByProjectId(projectId);
		return new ResponseEntity<>(tickets,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable long ticketId){
		try {
			ticketService.deleteTicketById(ticketId);
			return ResponseEntity.ok("Ticket deleted successfully");
		}catch(IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
