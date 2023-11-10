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
/**
 * application transaction model class
 */
@Entity
@Table(name = "transaction")
public class TransactionDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "transaction_id")
	private int idTransaction;
	
	@Column( name = "type_transaction")
	private String typeTransaction;
	
	@Column( name = "amount_asked")
	private float amountAsked;
	
	@Column( name = "amount_commission")
	private float amountCommission;

	@Column( name = "description")
	private String description;
	
	@ManyToOne( 
			cascade = CascadeType.MERGE
			)
	@JoinColumn( name = "recipient_id")
	private UserDto  recipient;
	
	
	@ManyToOne( 
			cascade = CascadeType.MERGE
			)
	@JoinColumn( name = "issuer_id")
	private UserDto issuer;

	
	
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


	public float getAmountAsked() {
		return amountAsked;
	}


	public void setAmountAsked(float amountAsked) {
		this.amountAsked = amountAsked;
	}


	public float getAmountCommission() {
		return amountCommission;
	}


	public void setAmountCommission(float amountCommission) {
		this.amountCommission = amountCommission;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public UserDto getRecipient() {
		return recipient;
	}


	public void setRecipient(UserDto recipient) {
		this.recipient = recipient;
	}


	public UserDto getIssuer() {
		return issuer;
	}


	public void setIssuer(UserDto issuer) {
		this.issuer = issuer;
	}
	
	

	public TransactionDto(int idTransaction, String typeTransaction, float amountAsked, float amountCommission,
			String description, UserDto recipient, UserDto issuer) {
		super();
		this.idTransaction = idTransaction;
		this.typeTransaction = typeTransaction;
		this.amountAsked = amountAsked;
		this.amountCommission = amountCommission;
		this.description = description;
		this.recipient = recipient;
		this.issuer = issuer;
	}


	public TransactionDto() {
		// TODO Auto-generated constructor stub
	}


	

}
