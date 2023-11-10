package com.openclassroom.Projet6JavaPayMyBuddy.model;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *  application user model class
 */
@Entity
@Table(name = "user")
public class UserDto {
	
	

	@Id
	@Column( name = "id" )
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
		
	
	
	@Column( name = "account_balance")
	private float accountBalance;
		
	@Column( name = "rib")
	private String rib;
		
	@Column( name = "email")
	private String email;
	
	@Column( name = "name")
	private String name;
	
	@Column( name = "password")
	private String password;
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	    @JoinTable(
	            name = "friend",
	            joinColumns = @JoinColumn(
	                    name = "id_issuer", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(
	                    name = "id_recipient", referencedColumnName = "id"))
	    private List<UserDto> friends = new ArrayList<>();
	
	@OneToMany(
			mappedBy ="recipient",
			cascade =CascadeType.ALL,
			orphanRemoval = true)
	List<TransactionDto> issuers = new ArrayList<>();
	
	@OneToMany(
			mappedBy ="issuer",
			cascade =CascadeType.ALL,
			orphanRemoval = true)
     List<TransactionDto> recipients = new ArrayList<>();

	

	public UserDto(int idUser, String name, float accountBalance, String rib, String email, String password) {
		super();
		this.idUser = idUser;
		this.accountBalance = accountBalance;
		this.rib = rib;
		this.email = email;
		this.password = password;
	}



	public UserDto() {
		// TODO Auto-generated constructor stub
	}

		
		public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



	public float getAccountBalance() {
		return accountBalance;
	}



	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}



	public String getRib() {
		return rib;
	}



	public void setRib(String rib) {
		this.rib = rib;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<UserDto> getFriends() {
		return friends;
	}



	public void setFriends(List<UserDto> friends) {
		this.friends = friends;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<TransactionDto> getIssuers() {
		return issuers;
	}



	public void setIssuers(List<TransactionDto> issuers) {
		this.issuers = issuers;
	}



	public List<TransactionDto> getRecipients() {
		return recipients;
	}



	public void setRecipients(List<TransactionDto> recipients) {
		this.recipients = recipients;
	}



	






		



		


	
	
	}
