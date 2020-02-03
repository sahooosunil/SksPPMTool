package io.sks.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sks.ppmtool.domain.Project;
import io.sks.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository ProjectRepo;
	
	public Project saveOrUpdateProject(Project project) {
		return ProjectRepo.save(project);
	}
}
