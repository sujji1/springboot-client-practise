package com.example.springbootclientpractise;

import jakarta.persistence.*;

@Entity
public class Shop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String adress;
	public Shop() {
		
	}
	public Shop(int id, String name, String adress) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", adress=" + adress + "]";
	}
	

}
