package io.sks.ppmtool.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.sks.ppmtool.domain.Project;
import io.sks.ppmtool.services.MapValidationErrorService;
import io.sks.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
		ResponseEntity<?> mapValidationService = mapValidationErrorService.mapValidationService(result);
		if(mapValidationService!=null)
			return mapValidationService;
		Project projectSaved = projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(projectSaved, HttpStatus.CREATED);
	}

}
