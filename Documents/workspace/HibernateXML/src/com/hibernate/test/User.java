package com.hibernate.test;

import hibernate.model.Adress;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity 
@Table
public class User {
	@Id @GeneratedValue
	private int id;
	private String name;
	private String pword;
	
	@ElementCollection
	@JoinTable(name="UserAddress", joinColumns = @JoinColumn(name="idUser")) //change table name and fk names
	
	//@GenericGenerator(name="hilo-gen", strategy="hilo") //hilo is a generator of primary key range
														//from from high to low type that hibernate supplies
	//@CollectionId(columns = { @Column(name="userAddress_id") }, generator = "hilo-gen", type = @Type(type="long"))
	
	private Collection<Adress>listOfAddresses = new ArrayList<Adress>(); //arraylist implements indexes but sets do not
	//private Set<Adress>listOfAddresses = new HashSet<Adress>();

	/**
	 * @return the listOfAddresses
	 */
	public Collection<Adress> getListOfAddresses() {
		return listOfAddresses;
	}
	/**
	 * @param listOfAddresses the listOfAddresses to set
	 */
	public void setListOfAddresses(Collection<Adress> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	/**
	 * @param listOfAddresses the listOfAddresses to set
	 */
	public void setListOfAddresses(Set<Adress> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pword
	 */
	public String getPword() {
		return pword;
	}
	/**
	 * @param pword the pword to set
	 */
	public void setPword(String pword) {
		this.pword = pword;
	}

	/**
	 * @param args
	 */

}
