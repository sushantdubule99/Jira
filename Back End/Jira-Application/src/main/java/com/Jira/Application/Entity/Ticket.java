package com.Jira.Application.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ticketId;
    @Column(name="ticket_guid")
	private String ticketGuid;
	private String summary;
	private long storyPoint;
	private String status;
	private String assignedTo;
	private String projectShortName;
	private String issue;
	private String createdBy;
	@ManyToOne
	@JoinColumn(name="project_id", nullable = false)
	@JsonBackReference
	private Project project;
	public Ticket(long ticketId, String ticketGuid, String summary, long storyPoint, String status, String assignedTo,
			String projectShortName, String issue, String createdBy, Project project) {
		super();
		this.ticketId = ticketId;
		this.ticketGuid = ticketGuid;
		this.summary = summary;
		this.storyPoint = storyPoint;
		this.status = status;
		this.assignedTo = assignedTo;
		this.projectShortName = projectShortName;
		this.issue = issue;
		this.createdBy = createdBy;
		this.project = project;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketGuid() {
		return ticketGuid;
	}
	public void setTicketGuid(String ticketGuid) {
		this.ticketGuid = ticketGuid;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public long getStoryPoint() {
		return storyPoint;
	}
	public void setStoryPoint(long storyPoint) {
		this.storyPoint = storyPoint;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getProjectShortName() {
		return projectShortName;
	}
	public void setProjectShortName(String projectShortName) {
		this.projectShortName = projectShortName;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

	
}
