package org.mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projects {
	
	@Id
	private long projectId;
	
	@Column(length = 50)
	private String projectName;
	
	
	@ManyToMany(mappedBy = "projects")
	private List<Employees> employees;

	public List<Employees> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}


	public Projects() {
		
	}


	public Projects(long projectId, String projectName) {
		
		this.projectId = projectId;
		this.projectName = projectName;
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


	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", projectName=" + projectName + "]";
	}
	
	

}
