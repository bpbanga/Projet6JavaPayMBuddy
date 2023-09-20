package com.openclassroom.Projet6JavaPayMyBuddy.model;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "transaction_id")
	private int idTransaction;
	
	@Column( name = "type_transaction")
	private String typeTransaction;
	
	@Column( name = "montant_demande")
	private float montantDemande;
	
	@Column( name = "montant_commision")
	private float montantCommision;

	@Column( name = "description")
	private String description;
	
	@ManyToOne( 
			cascade = CascadeType.MERGE
			)
	@JoinColumn( name = "destinataire_id")
	private Utilisateur  destinataire;
	
	
	@ManyToOne( 
			cascade = CascadeType.MERGE
			)
	@JoinColumn( name = "emmeteur_id")
	private Utilisateur emmeteur;

	
	
	public int getIdTransaction() {
		return idTransaction;
	}


	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}


	public String getTypeTransaction() {
		return typeTransaction;
	}


	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}


	public float getMontantDemande() {
		return montantDemande;
	}


	public void setMontantDemande(float montantDemande) {
		this.montantDemande = montantDemande;
	}


	public float getMontantCommision() {
		return montantCommision;
	}


	public void setMontantCommision(float montantCommision) {
		this.montantCommision = montantCommision;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Utilisateur getDestinataire() {
		return destinataire;
	}


	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}


	public Utilisateur getEmmeteur() {
		return emmeteur;
	}


	public void setEmmeteur(Utilisateur emmeteur) {
		this.emmeteur = emmeteur;
	}
	
	

	public Transaction(int idTransaction, String typeTransaction, float montantDemande, float montantCommision,
			String description, Utilisateur destinataire, Utilisateur emmeteur) {
		super();
		this.idTransaction = idTransaction;
		this.typeTransaction = typeTransaction;
		this.montantDemande = montantDemande;
		this.montantCommision = montantCommision;
		this.description = description;
		this.destinataire = destinataire;
		this.emmeteur = emmeteur;
	}
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}




	public Transaction(Object object, Object object2) {
		// TODO Auto-generated constructor stub
	}
}
