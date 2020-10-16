package com.eduardopagliaroni.database;

public class Person {

	private int id;
	private String name;

	public Person() {

	}
	
	public Person(int _id, String _name) {
		this.id = _id;
		this.name = _name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
