package org.spring;


public class Student {
	
	private long id;
	private String name;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	} 
	
	

}
