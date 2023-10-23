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


@Entity
@Table(name = "utilisateur")
public class UserDto {
	
	

	@Id
	@Column( name = "id" )
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUtilisateur;
		
	
	
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
	            name = "ami",
	            joinColumns = @JoinColumn(
	                    name = "id_emetteur", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(
	                    name = "id_recepteur", referencedColumnName = "id"))
	    private List<UserDto> amis = new ArrayList<>();
	
	@OneToMany(
			mappedBy ="destinataire",
			cascade =CascadeType.ALL,
			orphanRemoval = true)
	List<TransactionDto> emetteurs = new ArrayList<>();
	
	@OneToMany(
			mappedBy ="emmeteur",
			cascade =CascadeType.ALL,
			orphanRemoval = true)
     List<TransactionDto> recepteurs = new ArrayList<>();

	

	public UserDto(int idUtilisateur, String nom, float accountBalance, String rib, String email, String password) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.accountBalance = accountBalance;
		this.rib = rib;
		this.email = email;
		this.password = password;
	}



	public UserDto() {
		// TODO Auto-generated constructor stub
	}

		
		public int getIdUtilisateur() {
		return idUtilisateur;
	}



	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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



	public List<UserDto> getAmis() {
		return amis;
	}



	public void setAmis(List<UserDto> amis) {
		this.amis = amis;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<TransactionDto> getEmetteurs() {
		return emetteurs;
	}



	public void setEmetteurs(List<TransactionDto> emetteurs) {
		this.emetteurs = emetteurs;
	}



	public List<TransactionDto> getRecepteurs() {
		return recepteurs;
	}



	public void setRecepteurs(List<TransactionDto> recepteurs) {
		this.recepteurs = recepteurs;
	}






		



		


	
	
	}
