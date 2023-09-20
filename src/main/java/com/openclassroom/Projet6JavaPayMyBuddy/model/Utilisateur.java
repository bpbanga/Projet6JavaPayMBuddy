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
public class Utilisateur {
	
	

	@Id
	@Column( name = "id" )
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUtilisateur;
		
	
	
	@Column( name = "solde_compte")
	private float soldeCompte;
		
	@Column( name = "rib")
	private String rib;
		
	@Column( name = "email")
	private String email;
	
	@Column( name = "nom")
	private String nom;
	
	@Column( name = "password")
	private String password;
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	    @JoinTable(
	            name = "ami",
	            joinColumns = @JoinColumn(
	                    name = "id_emetteur", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(
	                    name = "id_recepteur", referencedColumnName = "id"))
	    private List<Utilisateur> amis = new ArrayList<>();
	
	@OneToMany(
			mappedBy ="destinataire",
			cascade =CascadeType.ALL,
			orphanRemoval = true)
	List<Transaction> emetteurs = new ArrayList<>();
	
	@OneToMany(
			mappedBy ="emmeteur",
			cascade =CascadeType.ALL,
			orphanRemoval = true)
     List<Transaction> recepteurs = new ArrayList<>();

	

	public Utilisateur(int idUtilisateur, String nom, float soldeCompte, String rib, String email, String password) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.soldeCompte = soldeCompte;
		this.rib = rib;
		this.email = email;
		this.password = password;
	}



	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

		
		public int getIdUtilisateur() {
		return idUtilisateur;
	}



	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}



	public float getSoldeCompte() {
		return soldeCompte;
	}



	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
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



	public List<Utilisateur> getAmis() {
		return amis;
	}



	public void setAmis(List<Utilisateur> amis) {
		this.amis = amis;
	}


	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public List<Transaction> getEmetteurs() {
		return emetteurs;
	}



	public void setEmetteurs(List<Transaction> emetteurs) {
		this.emetteurs = emetteurs;
	}



	public List<Transaction> getRecepteurs() {
		return recepteurs;
	}



	public void setRecepteurs(List<Transaction> recepteurs) {
		this.recepteurs = recepteurs;
	}






		



		


	
	
	}
