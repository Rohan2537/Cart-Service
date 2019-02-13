package com.capgemini.eshoppingZone.ewallet.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ewallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId;
	private Double currentBalance;
	@OneToMany(mappedBy = "ewallet")
	@JsonManagedReference
	private List<Statement> statements;

	public Ewallet() {
	}

	public Ewallet(Double currentBalance, List<Statement> statements) {
		super();
		this.currentBalance = currentBalance;
		this.statements = statements;
	}

	public Ewallet(Integer walletId, Double currentBalance) {
		super();
		this.walletId = walletId;
		this.currentBalance = currentBalance;
	}

	public Ewallet(Integer walletId, Double currentBalance, List<Statement> statements) {
		super();
		this.walletId = walletId;
		this.currentBalance = currentBalance;
		this.statements = statements;
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public String toString() {
		return "Ewallet [walletId=" + walletId + ", currentBalance=" + currentBalance + ", statements=" + statements
				+ "]";
	}

}
