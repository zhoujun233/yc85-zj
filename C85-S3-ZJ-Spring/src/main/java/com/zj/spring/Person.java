package com.zj.spring;

import java.util.List;

public class Person {
	
	private String name;
	private int age;
	private List<String> kills;
	private int height;
	private String alisa;
	private Person friend;
	
	/**
	 * 静态工厂方法
	 */
	public static Person PersonFactory() {
		Person p=new Person();
		p.setAge(40);
		return p;
		
	}
	
	/**
	 * 实例工厂方法
	 */
	public Person PersonFactory1() {
		Person p=new Person();
		p.setAge(20);
		return p;
		
	}
	
	
	public Person() {
		
	}
	
	public Person(String name, int age, String alisa) {
		super();
		this.name = name;
		this.age = age;
		this.alisa = alisa;
		System.out.println("=========1=========");
	}
	
	public Person(int age,String name,  String alisa) {
		super();
		this.name = name;
		this.age = age;
		this.alisa = alisa;
		System.out.println("=========2=========");
	}
	
	public Person getFriend() {
		return friend;
	}

	public void setFriend(Person friend) {
		this.friend = friend;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getKills() {
		return kills;
	}
	public void setKills(List<String> kills) {
		this.kills = kills;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getAlisa() {
		return alisa;
	}
	public void setAlisa(String alisa) {
		this.alisa = alisa;
	}
	
	

}
