package com.Jira.Application.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;
    @Column(name="project_name")
	private String projectName;
	private String shortName;
	private Date createdDate;
	@OneToMany(mappedBy = "project" , cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Ticket> tickets;
	public Project(long projectId, String projectName, String shortName, Date createdDate, List<Ticket> tickets) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.shortName = shortName;
		this.createdDate = createdDate;
		this.tickets = tickets;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
}
