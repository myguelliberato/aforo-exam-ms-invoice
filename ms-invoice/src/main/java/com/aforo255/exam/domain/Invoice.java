package com.aforo255.exam.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8520451931566665455L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_invoice")
	private Integer invoiceId;
	@Column(name = "amount")
	private double amount;
	@Column(name = "state")
	private Integer state;
}
