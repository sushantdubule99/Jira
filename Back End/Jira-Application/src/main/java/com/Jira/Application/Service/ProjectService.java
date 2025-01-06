package com.Jira.Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jira.Application.Entity.Project;
import com.Jira.Application.Repository.ProjectRepository;

@Service
public class ProjectService {
  
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project>getAllprojects(){
		return projectRepository.findAll();
	}
	
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
}
