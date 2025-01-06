package com.Jira.Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jira.Application.Entity.Project;
import com.Jira.Application.Service.ProjectService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/projects")
public class ProjectController {
  
	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	public List<Project>getAllProjects(){
		return projectService.getAllprojects();
	}
	
	@PostMapping
	public ResponseEntity<Project>createProject(@RequestBody Project project ){
		Project savedProject = projectService.createProject(project);
		return new ResponseEntity<>(savedProject,HttpStatus.CREATED);
	}
}
