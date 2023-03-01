package org.mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeId;

	@Column(length = 50, nullable = false)
	private String firstName;
	
	@Column(length = 50, nullable = false)
	private String lastName;
	
	@Column(nullable = false, updatable = true)
	private double salary;
	
	@ManyToMany
	@JoinTable(name="employees_projects", joinColumns = { @JoinColumn(name="employeeId")}, inverseJoinColumns = { @JoinColumn(name="projectId")})
	List<Projects> projects;

	public Employees() {
		
		
	}

	public Employees( String firstName, String lastName, double salary) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
 
	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + "]";
	}
	

}
