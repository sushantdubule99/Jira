package com.Jira.Application.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jira.Application.Entity.Project;
import com.Jira.Application.Entity.Ticket;

import com.Jira.Application.Repository.ProjectRepository;
import com.Jira.Application.Repository.TicketRepository;

@Service
public class TicketService {
  
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Ticket>getAllTickets(){
		return ticketRepository.findAll();
	}
	
	public Ticket saveTicket(Ticket ticket , Long projectId) {
		Project project = projectRepository.findById(projectId).orElseThrow();
		ticket.setProject(project);
		return ticketRepository.save(ticket);
		
		
	}
	
	public List<Ticket>getAllTicketsByProjectId(Long projectId){
		return ticketRepository.findByProject_ProjectId(projectId);
	}
	
	 public void deleteTicketById(long ticketId) {
		 Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
		 if(ticketOptional.isPresent()) {
			 ticketRepository.deleteById(ticketId);
		 }else {
			 throw new IllegalArgumentException("Ticket not found with id" +ticketId);
		 }
	 }
		
}
